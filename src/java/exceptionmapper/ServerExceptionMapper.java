package exceptionmapper;

import com.google.gson.JsonObject;
import exception.ServerException;
import java.util.Arrays;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ServerExceptionMapper implements ExceptionMapper<ServerException> {

    @Context
    ServletContext context;

    @Override
    public Response toResponse(ServerException e) {
        JsonObject jo = new JsonObject();
        if (Boolean.valueOf(context.getInitParameter("debug"))) {
            jo.addProperty("StackTrace", Arrays.toString(e.getStackTrace()));
        }
        jo.addProperty("message", e.getMessage());
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(jo.toString()).type(MediaType.APPLICATION_JSON).build();
    }
}
