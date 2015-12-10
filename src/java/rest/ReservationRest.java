package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import deploy.DeploymentConfiguration;
import entity.Reservation;
import exception.NoResultException;
import exception.ReservationException;
import exception.ServerException;
import facades.ReservationFacade;
import interfaces.IReservationFacade;
import java.io.IOException;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import static utility.JsonConverter.toJson;

@Path("reservation")
@RolesAllowed("User")
public class ReservationRest {

    private final IReservationFacade ctrl;
    private final Gson gson;

    public ReservationRest() {
        ctrl = new ReservationFacade();
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").setPrettyPrinting().create();
    }

    @GET
    @Path("{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsersReservations(@PathParam("username") String username) throws NoResultException {
        List<Reservation> list = ctrl.getReservations(username);
        System.out.println(toJson(list));
        return Response.ok(toJson(list)).build();
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllReservations() throws NoResultException {
        List<Reservation> list = ctrl.getReservations("");
        System.out.println(toJson(list));
        return Response.ok(toJson(list)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response reserveTickets(String reservation) throws IOException, ServerException, ReservationException {
        ctrl.reserveTickets(gson.fromJson(reservation, Reservation.class));
        String success = "{\"message\":\"Tickets succesfully reserved\"}";
        return Response.status(Status.OK).entity(success).build();
    }
}
