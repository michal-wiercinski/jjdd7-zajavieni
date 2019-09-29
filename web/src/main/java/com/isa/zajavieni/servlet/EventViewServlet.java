package com.isa.zajavieni.servlet;

import com.isa.zajavieni.dto.BookingDto;
import com.isa.zajavieni.dto.EventDto;
import com.isa.zajavieni.entity.Event;
import com.isa.zajavieni.entity.UserType;
import com.isa.zajavieni.provider.TemplateProvider;
import com.isa.zajavieni.service.BookingService;
import com.isa.zajavieni.service.EmailSenderService;
import com.isa.zajavieni.service.EventDtoService;
import com.isa.zajavieni.service.FavouriteEventService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/event-view")
public class EventViewServlet extends HttpServlet {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());
  @EJB
  private EventDtoService eventDtoService;

  @EJB
  private BookingService bookingService;

  @Inject
  private FavouriteEventService favouriteEventService;

  @Inject
  private TemplateProvider templateProvider;

  @EJB
  private EmailSenderService emailSenderService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    Long id;
    EventDto eventDto = new EventDto();
    Event event = new Event();
    String eventId = req.getParameter("id");

    if (eventId != null || !eventId.isEmpty() || NumberUtils.isDigits(eventId)) {
      id = Long.valueOf(eventId);
      eventDto = eventDtoService.findById(id);
      event = eventDtoService.findEventById(id);
    }

    Template template = templateProvider.getTemplate(getServletContext(), "event-details.ftlh");
    Map<String, Object> model = new HashMap<>();
    model.put("event", eventDto);

    Long userId = (Long) req.getSession().getAttribute("userId");

    if (userId != null) {
      Boolean isFavourite = false;
      if (favouriteEventService.findListOfUserFavouriteEvents(userId).stream().map(e -> e.getId())
          .collect(
              Collectors.toList()).contains(event.getId())) {
        isFavourite = true;
      }

      List<EventDto> favouriteEvents = favouriteEventService
          .findListOfUserFavouriteEventsDto(userId);
      favouriteEventService.displayFavouriteEventBeam(req, favouriteEvents, model);
      model.put("isFavourite", isFavourite);
      model.put("userId", userId);
      List<BookingDto> bookingsForUser = bookingService.findBookingsForUser(userId);

      for (BookingDto bookingDto : bookingsForUser) {
        if (eventDto.getId().equals(bookingDto.getEventDto().getId())) {
          eventDto.setBookedForUser(true);
          continue;
        }
      }
    }
    String userType;
    if (!(req.getSession().getAttribute("userType") == null)) {
      userType = String.valueOf(req.getSession().getAttribute("userType"));
      model.put("type", userType);
    } else {
      userType = UserType.GUEST.name();
      model.put("type", userType);
    }

    try {
      template.process(model, resp.getWriter());
    } catch (TemplateException e) {
      logger.error(e.getMessage());
    }
  }

  @Override
  protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Long eventId = Long.parseLong(req.getParameter("id"));
    emailSenderService.sendDeletedEventEmailForUsers(eventId);
    eventDtoService.deleteEventFromBase(eventId);
  }
}