package com.isa.zajavieni.web.servlet;

import com.isa.zajavieni.dto.BookingDto;
import com.isa.zajavieni.dto.EventDto;
import com.isa.zajavieni.entity.createdentity.UserType;
import com.isa.zajavieni.provider.TemplateProvider;
import com.isa.zajavieni.service.dtoservice.BookingService;
import com.isa.zajavieni.service.dtoservice.EventDtoService;
import com.isa.zajavieni.service.dtoservice.FavouriteEventService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());
  private static final int EVENTS_PER_PAGE = 8;
  private static final int FIRST_ELEMENT = 0;

  @EJB
  private EventDtoService eventService;

  @Inject
  private TemplateProvider templateProvider;

  @Inject
  private FavouriteEventService favouriteEventService;

  @EJB
  private BookingService bookingService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    List<EventDto> events = eventService.findUpcomingEvents(FIRST_ELEMENT, EVENTS_PER_PAGE);
    Template template = templateProvider.getTemplate(getServletContext(), "welcome-page.ftlh");
    Map<String, Object> model = new HashMap<>();
    model.put("events", events);
    Long userId = (Long) req.getSession().getAttribute("userId");

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
    List<BookingDto> bookingsForUser = bookingService.findBookingsForUser(userId);

    events.forEach(e -> {
      for (BookingDto bookingDto : bookingsForUser) {
        if (e.getId().equals(bookingDto.getEventDto().getId())) {
          e.setBookedForUser(true);
          continue;
        }
      }
    });

    try {
      template.process(model, resp.getWriter());
    } catch (TemplateException e) {
      logger.error(e.getMessage());
    }
  }
}