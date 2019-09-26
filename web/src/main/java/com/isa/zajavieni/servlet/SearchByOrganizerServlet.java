package com.isa.zajavieni.servlet;

import com.isa.zajavieni.dto.EventDto;
import com.isa.zajavieni.provider.TemplateProvider;
import com.isa.zajavieni.service.EventDtoService;
import com.isa.zajavieni.service.FavouriteEventService;
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
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/filter-by-organizer")
public class SearchByOrganizerServlet extends HttpServlet {

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
    Long id = null;
    String idParam = req.getParameter("id");
    if (idParam != null && !idParam.isEmpty() && NumberUtils.isDigits(idParam)) {
      id = Long.valueOf(idParam);
    } else {
      resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }

    int pageNumber = 0;
    String pageParameter = req.getParameter(PAGE_NUMBER);
    if (pageParameter != null && !pageParameter.isEmpty() && NumberUtils.isDigits(pageParameter)) {
      pageNumber = Integer.valueOf(pageParameter);
    } else {
      resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }

    int totalPages = eventDtoService.getTotalPagesOrganizersEvent(id, EVENTS_PER_PAGE);

    List<EventDto> events = eventDtoService
        .findEventsByOrganizerId(id, pageNumber, EVENTS_PER_PAGE);

    Template template = templateProvider.getTemplate(getServletContext(), "organizers-event.ftlh");
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
    }

    try {
      template.process(model, resp.getWriter());
    } catch (TemplateException e) {
      logger.error(e.getMessage());
    }
  }
}