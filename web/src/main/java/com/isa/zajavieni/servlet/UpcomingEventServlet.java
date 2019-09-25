package com.isa.zajavieni.servlet;

import com.isa.zajavieni.dto.EventDto;
import com.isa.zajavieni.provider.TemplateProvider;
import com.isa.zajavieni.service.EventDtoService;
import com.isa.zajavieni.service.FavouriteEventService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/upcoming-events")
public class UpcomingEventServlet extends HttpServlet {

  private static final int EVENTS_PER_PAGE = 8;
  private static final String PAGE_NUMBER = "pageNo";
  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @EJB
  private EventDtoService eventDtoService;

  @Inject
  private TemplateProvider templateProvider;

  @Inject
  private FavouriteEventService favouriteEventService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    int totalPages = eventDtoService.getTotalPagesUpcomingEvent(EVENTS_PER_PAGE);
    String pageParameter = req.getParameter(PAGE_NUMBER);

    int pageNumber = Integer.valueOf(pageParameter);

    List<EventDto> events = eventDtoService.findUpcomingEvents(pageNumber, EVENTS_PER_PAGE);

    Template template = templateProvider.getTemplate(getServletContext(), "upcoming-events.ftlh");
    Map<String, Object> model = new HashMap<>();
    model.put("events", events);
    model.put("page", pageNumber);
    model.put("totalPages", totalPages);

    //Long userId = Long.parseLong((String) req.getSession().getAttribute("userId"));
    Long userId = 2L;
    List<EventDto> favouriteEvents = favouriteEventService.findListOfUserFavouriteEventsDto(userId);

    if (req.getSession().getAttribute("isVisible").equals("visible")) {
      if (favouriteEvents.size() != 0) {
        EventDto upcomingEvent = favouriteEvents.stream().findFirst().get();
        model.put("upcomingEvent", upcomingEvent);
      }
    }

    try {
      template.process(model, resp.getWriter());
    } catch (TemplateException e) {
      logger.error(e.getMessage());
    }
  }
}