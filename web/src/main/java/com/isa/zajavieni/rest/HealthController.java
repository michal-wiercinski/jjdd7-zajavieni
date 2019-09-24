package com.isa.zajavieni.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/health")
public class HealthController {
    @GET
    public Response checkHealth() {
        return Response.ok().build();
    }
}
