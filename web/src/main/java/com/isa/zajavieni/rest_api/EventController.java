package com.isa.zajavieni.rest_api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.isa.zajavieni.service.EventDtoService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1.0")
public class EventController {

    @Inject
    EventDtoService eventDtoService;

    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getModal(@PathParam("id") Long id) throws JsonProcessingException {
        return Response.ok()
                .entity(eventDtoService.findById(id))
                .build();
    }
}
