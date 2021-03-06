package matutu.giosan777.ge.rs;

import matutu.giosan777.ge.userPoint.UserCheck;
import matutu.giosan777.ge.userPoint.UserIdGet;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;


@ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(UserCheck.class);
        resources.add(UserIdGet.class);
    }

}
