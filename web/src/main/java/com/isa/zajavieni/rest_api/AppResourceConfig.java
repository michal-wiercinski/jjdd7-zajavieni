package com.isa.zajavieni.rest_api;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class AppResourceConfig extends ResourceConfig {

    public AppResourceConfig() {
            // Define the package which contains the service classes.
            packages("com.isa.zajavieni.rest_api");
        }
    }
