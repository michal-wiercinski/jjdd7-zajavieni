package com.isa.zajavieni.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.isa.zajavieni.service.statistic.PopularityEventApiService;
import com.isa.zajavieni.service.statistic.PopularityFavouriteEventApiService;
import com.isa.zajavieni.service.statistic.PopularityOrganizerApiService;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/statistics")
public class AdminStatisticController {
  @Inject
  private PopularityEventApiService popularityEventApiService;

  @Inject
  private PopularityFavouriteEventApiService popularityFavouriteEventApiService;

  @Inject
  private PopularityOrganizerApiService popularityOrganizerApiService;

  @GET
  @Path("/events")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getPopularityEventStats() throws JsonProcessingException {
    return Response.ok()
        .entity(popularityEventApiService.getPopularityEventJsonObject())
        .build();
  }

  @GET
  @Path("/organizers")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getPopularityOrganizerStats() throws JsonProcessingException {
    return Response.ok()
        .entity(popularityOrganizerApiService.getPopularityOrganizerJsonObject())
        .build();
  }

  @GET
  @Path("/favouriteEvents")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getPopularityFavouriteEventStats() throws JsonProcessingException {
    return Response.ok()
        .entity(popularityFavouriteEventApiService.getPopularityFavouriteEventJsonObject())
        .build();
  }
}
