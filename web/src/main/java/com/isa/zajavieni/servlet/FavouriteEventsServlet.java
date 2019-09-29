package com.isa.zajavieni.servlet;

import com.isa.zajavieni.dto.BookingDto;
import com.isa.zajavieni.dto.EventDto;
import com.isa.zajavieni.entity.Event;
import com.isa.zajavieni.entity.UserType;
import com.isa.zajavieni.provider.TemplateProvider;
import com.isa.zajavieni.service.BookingService;
import com.isa.zajavieni.service.EventDtoService;
import com.isa.zajavieni.service.FavouriteEventService;
import com.isa.zajavieni.service.statistic.PopularityFavouriteEventService;
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

@WebServlet("/favourite-events")
public class FavouriteEventsServlet extends HttpServlet {

  private Logger logger = LoggerFactory.getLogger(LoggerServlet.class.getName());

  @Inject
  private FavouriteEventService favouriteEventService;

  @EJB
  private BookingService bookingService;

  @Inject
  private TemplateProvider templateProvider;

  @Inject
  private PopularityFavouriteEventService popularityFavouriteEventService;

  @EJB
  private EventDtoService eventDtoService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    logger.info("Request GET method");
    Long userId = (Long) req.getSession().getAttribute("userId");
    List<EventDto> favouriteEvents = favouriteEventService
        .findListOfUserFavouriteEventsDto(userId);

    Template template = templateProvider.getTemplate(getServletContext(), "favourite.ftlh");
    Map<String, Object> model = new HashMap<>();
    favouriteEventService.displayFavouriteEventBeam(req, favouriteEvents, model);
    model.put("favouriteEvents", favouriteEvents);
    model.put("userId", userId);

    List<BookingDto> bookingsForUser = bookingService.findBookingsForUser(userId);

    favouriteEvents.forEach(e -> {
      for (BookingDto bookingDto : bookingsForUser) {
        if (e.getId().equals(bookingDto.getEventDto().getId())) {
          e.setBookedForUser(true);
          continue;
        }
      }
    });
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
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    logger.info("Request POST method");
    String eventId = req.getParameter("id");
    String userId = String.valueOf(req.getSession().getAttribute("userId"));
    favouriteEventService.addEventToUserFavouriteEvents(eventId, userId);
    Event event = eventDtoService.findEventById(Long.parseLong(eventId));
    popularityFavouriteEventService.incrementQuantityPopularityEvent(event.getPopularityFavouriteEvent().getId());
  }

  @Override
  protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    logger.info("Request DELETE method");
    String eventId = req.getParameter("id");
    String userId = String.valueOf(req.getSession().getAttribute("userId"));
    favouriteEventService.deleteEventFromUserFavouriteEvents(eventId, userId);
  }

  @Override
  protected void doPut(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.getSession().setAttribute("isVisible", "false");
  }
}
