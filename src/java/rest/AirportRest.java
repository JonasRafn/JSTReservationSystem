package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import deploy.DeploymentConfiguration;
import entity.Airport;
import facades.AirportFacade;
import interfaces.IAirportFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("airports")
public class AirportRest {

    private IAirportFacade ctrl;
    private Gson gson;
    private EntityManagerFactory emf;

    public AirportRest() {
        emf = Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME);
        ctrl = new AirportFacade(emf);
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAirports() {
        
        List<Airport> airports = ctrl.getAirports();
        return Response.ok(gson.toJson(airports)).build();
        
    }
}