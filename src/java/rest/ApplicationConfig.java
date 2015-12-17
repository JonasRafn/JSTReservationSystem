package rest;

import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method. It is automatically
     * populated with all resources defined in the project. If required, comment
     * out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(exceptionmapper.AllExceptionMapper.class);
        resources.add(exceptionmapper.NoResultExceptionMapper.class);
        resources.add(exceptionmapper.ServerExceptionMapper.class);
        resources.add(rest.AirportRest.class);
        resources.add(rest.CreateUserRest.class);
        resources.add(rest.DashboardRest.class);
        resources.add(rest.FlightInfoRest.class);
        resources.add(rest.ReservationRest.class);
        resources.add(security.JWTAuthenticationFilter.class);
        resources.add(security.Login.class);
        resources.add(security.NotAuthorizedExceptionMapper.class);
        resources.add(security.RolesAllowedFilter.class);
    }

}
