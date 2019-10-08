package com.isa.zajavieni.web.rest;

import com.isa.zajavieni.jsonresponse.EventResponse;
import com.isa.zajavieni.service.dtoservice.EventDtoService;
import com.isa.zajavieni.service.jsonservice.EventResponseService;
import javax.ejb.EJB;
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
  EventResponseService eventResponseService;

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getSingleView(@PathParam("id") String idParam) {
    EventResponse eventResponse;
    Long id;
    if (NumberUtils.isDigits(idParam)) {
      id = Long.valueOf(idParam);
      eventResponse = eventResponseService.getEventJsonById(id);
      return Response.ok().entity(eventResponse).build();
    } else {
      return Response.serverError().build();
    }
  }
}
