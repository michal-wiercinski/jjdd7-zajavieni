package com.isa.zajavieni.servlet;

import com.isa.zajavieni.dto.EventDto;
import com.isa.zajavieni.provider.TemplateProvider;
import com.isa.zajavieni.service.FavouriteEventService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

  @Inject
  private TemplateProvider templateProvider;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    logger.info("Request GET method");
    Long userId = (Long) req.getSession().getAttribute("userId");
    List<EventDto> favouriteEvents = favouriteEventService
        .findListOfUserFavouriteEventsDto(userId);

    Template template = templateProvider.getTemplate(getServletContext(), "favourite.ftlh");
    Map<String, Object> model = new HashMap<>();
    favouriteEventService.displayFavouriteEventBeam(req,favouriteEvents,model);
    model.put("favouriteEvents", favouriteEvents);
    model.put("userId",userId);

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
