package com.isa.zajavieni.rest;

import com.isa.zajavieni.entity.Booking;
import com.isa.zajavieni.entity.Event;
import com.isa.zajavieni.entity.User;
import com.isa.zajavieni.service.BookingService;
import com.isa.zajavieni.service.EventService;
import com.isa.zajavieni.service.UserService;
import javax.ejb.EJB;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/booking")
public class BookingController {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @EJB
  UserService userService;

  @EJB
  EventService eventService;

  @EJB
  BookingService bookingService;

  @PATCH
  @Path("//make-booking/eventId/{eventId}/userId/{userId}")
  public Response addBooking(@PathParam("eventId") String eventIdParam,
      @PathParam("userId") String userIdParam) {
    if (!NumberUtils.isDigits(eventIdParam) || !NumberUtils.isDigits(userIdParam)) {
      return Response.status(Status.BAD_REQUEST).build();
    }
    Long eventId = Long.valueOf(eventIdParam);
    Long userId = Long.valueOf(userIdParam);

    if (userService.findUserById(userId) == null || eventService.findById(eventId) == null) {
      logger.warn("User with id: {} not found", userId);
      return Response.status(Status.NOT_FOUND).build();
    }


    User user = userService.findUserById(userId);
    Event event = eventService.findEventById(eventId);
    Booking booking = bookingService.createBooking(event,user);
    bookingService.saveBooking(booking);

 /*   logger.info("New booking with id: {} has been created for user with id{} and eventd with id {}  ",
        booking.getBookingId(),userId, eventId)*/;
    return Response.ok().build();

  }

}
