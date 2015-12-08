package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import deploy.DeploymentConfiguration;
import entity.Reservation;
import exception.ReservationException;
import exception.ServerException;
import facades.ReservationFacade;
import interfaces.IReservationFacade;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("reservation")
public class ReservationRest {

    private IReservationFacade ctrl;
    private Gson gson;

    public ReservationRest() {
        ctrl = new ReservationFacade();
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").setPrettyPrinting().create();
    }

    @GET
    @Path("{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReservations(@PathParam("username") String username) {
        List<Reservation> list = ctrl.getReservations(username);
        return Response.ok(gson.toJson(list)).build();
    }

    @POST
    @Path("{groupName}/{user}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response reservateTickets(@PathParam("groupName") String groupName, @PathParam("user") String user, String reservation) throws IOException, ServerException, ReservationException {
        ctrl.reservateTickets(reservation, groupName, user);
        String success = "{\"message\":\"Tickets succesfully reserved\"}";
        return Response.status(Status.OK).entity(success).build();
    }
}
