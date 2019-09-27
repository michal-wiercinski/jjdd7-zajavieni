package com.isa.zajavieni.servlet;


import com.isa.zajavieni.dto.BookingDto;
import com.isa.zajavieni.dto.EventDto;
import com.isa.zajavieni.entity.Event;
import com.isa.zajavieni.entity.User;
import com.isa.zajavieni.entity.UserType;
import com.isa.zajavieni.mapper.BookingDtoMapper;
import com.isa.zajavieni.mapper.EventDtoMapper;
import com.isa.zajavieni.provider.TemplateProvider;
import com.isa.zajavieni.service.EventService;
import com.isa.zajavieni.service.FavouriteEventService;
import com.isa.zajavieni.service.UserService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("tickets")
public class TicketServlet extends HttpServlet {

  @EJB
  private EventService eventService;

  @EJB
  private UserService userService;

  @Inject
  private TemplateProvider templateProvider;

  @EJB
  BookingDtoMapper bookingDtoMapper;

  @EJB
  EventDtoMapper eventDtoMapper;
  @Inject
  private FavouriteEventService favouriteEventService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    Long userId = (Long) req.getSession().getAttribute("userId");
    User user = userService.findUserById(userId);
    List<BookingDto> bookings = user.getBookings().stream()
        .map(booking -> bookingDtoMapper.mapEntityToDto(booking)).collect(Collectors.toList());
    List<EventDto> event = bookings.stream().


    Template template = templateProvider.getTemplate(getServletContext(), "tickets.ftlh");
    Map<String, Object> model = new HashMap<>();
    model.put("events", events);


    if (userId != null) {
      List<EventDto> favouriteEvents = favouriteEventService
          .findListOfUserFavouriteEventsDto(userId);
      favouriteEventService.displayFavouriteEventBeam(req, favouriteEvents, model);
      model.put("userId", userId);
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
}
