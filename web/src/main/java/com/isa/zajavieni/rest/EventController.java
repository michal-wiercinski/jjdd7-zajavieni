package com.isa.zajavieni.rest;

import com.isa.zajavieni.dto.EventDto;
import com.isa.zajavieni.entity.Event;
import com.isa.zajavieni.service.EventDtoService;
import javax.ejb.EJB;
import javax.json.Json;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.commons.lang3.math.NumberUtils;

@Path("/event")
public class EventController {

  @EJB
  EventDtoService eventDtoService;

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getSingleView(@PathParam("id") String idParam){
    EventDto eventDto = null;
    Long id;
    if(NumberUtils.isDigits(idParam)){
      id = Long.valueOf(idParam);
      eventDto = eventDtoService.findById(id);
    }else {
      Response.serverError().build();
    }
    return  Response.ok(eventDto, MediaType.APPLICATION_JSON).build();
  }
}
