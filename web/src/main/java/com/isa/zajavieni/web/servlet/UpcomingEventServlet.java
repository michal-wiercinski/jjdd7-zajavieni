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

@WebServlet("/upcoming-events")
public class UpcomingEventServlet extends HttpServlet {

  private static final int EVENTS_PER_PAGE = 8;
  private static final String PAGE_NUMBER = "pageNo";
  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @EJB
  private EventDtoService eventService;

  @EJB
  private BookingService bookingService;

  @Inject
  private TemplateProvider templateProvider;

  @EJB
  private FavouriteEventService favouriteEventService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    int totalPages = eventService.getTotalPagesUpcomingEvent(EVENTS_PER_PAGE);
    String pageParameter = req.getParameter(PAGE_NUMBER);

    int pageNumber = Integer.valueOf(pageParameter);

    List<EventDto> events = eventService.findUpcomingEvents(pageNumber, EVENTS_PER_PAGE);

    Template template = templateProvider.getTemplate(getServletContext(), "upcoming-events.ftlh");
    Map<String, Object> model = new HashMap<>();
    model.put("events", events);
    model.put("page", pageNumber);
    model.put("totalPages", totalPages);

    Long userId = (Long) req.getSession().getAttribute("userId");

    if (userId != null) {
      List<EventDto> favouriteEvents = favouriteEventService
          .findListOfUserFavouriteEventsDto(userId);

      favouriteEventService.displayFavouriteEventBeam(req, favouriteEvents, model);
      model.put("userId", userId);

      List<BookingDto> bookingsForUser = bookingService.findBookingsForUser(userId);

      events.forEach(e -> {
        for (BookingDto bookingDto : bookingsForUser) {
          if (e.getId().equals(bookingDto.getEventDto().getId())) {
            e.setBookedForUser(true);
            continue;
          }
        }
      });
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