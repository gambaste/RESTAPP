package it.stefanogamba.rename.rs;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class RestApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> set = new HashSet<>();
        set.add(HelloResource.class);
        set.add(JacksonConfiguration.class);
        return set;
    }
}
