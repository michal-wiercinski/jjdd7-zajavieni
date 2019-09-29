package com.isa.zajavieni.rest;

import com.isa.zajavieni.dto.BookingDto;
import com.isa.zajavieni.dto.EventDto;
import com.isa.zajavieni.dto.UserDto;
import com.isa.zajavieni.service.BookingService;
import com.isa.zajavieni.service.EmailSenderService;
import com.isa.zajavieni.service.EventDtoService;
import com.isa.zajavieni.service.UserService;
import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
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
  EventDtoService eventService;

  @EJB
  BookingService bookingService;

  @EJB
  EmailSenderService emailSenderService;

  @POST
  @Path("/make-booking/eventId/{eventId}/userId/{userId}")
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

    UserDto user = userService.findUserDtoById(userId);
    EventDto event = eventService.findById(eventId);
    Integer ticketPool = event.getTicketPool();
    if (ticketPool < 1) {
      return Response.status(Status.FOUND).build();
    }
    BookingDto booking = bookingService.createBooking(event, user);
    emailSenderService.sendBookingEmailForUser(userId, eventId);
    bookingService.saveBooking(booking);

    logger
        .info("New booking with id: {} has been created for user with id{} and eventd with id {}  ",
            booking.getBookingId(), userId, eventId);
    return Response.ok().build();
  }

  @DELETE
  @Path("/cancel-booking/eventId/{eventId}/userId/{userId}")
  public Response cancelBooking(@PathParam("eventId") String eventIdParam,
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

    EventDto event = eventService.findById(eventId);
    BookingDto booking = bookingService.findByEventAndUser(eventId, userId);
    Long id = booking.getBookingId();
    emailSenderService.sendCancelingBookingEmailForUser(userId, eventId);
    bookingService.deleteBooking(id);
    logger.info("Booking with id: {} has been canceled for user with id{} and eventd with id {}  ",
        id, userId, eventId);
    return Response.ok().build();
  }
}
