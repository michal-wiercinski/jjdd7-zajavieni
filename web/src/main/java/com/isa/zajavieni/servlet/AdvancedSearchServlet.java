package com.isa.zajavieni.servlet;

import com.isa.zajavieni.dto.EventDto;
import com.isa.zajavieni.provider.TemplateProvider;
import com.isa.zajavieni.service.FavouriteEventService;
import com.isa.zajavieni.service.SearchService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/advanced-search")
public class AdvancedSearchServlet extends HttpServlet {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @Inject
  private SearchService searchService;

  @Inject
  private TemplateProvider templateProvider;

  @Inject
  private FavouriteEventService favouriteEventService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    Template template = templateProvider
        .getTemplate(getServletContext(), "advanced-search.ftlh");
    Map<String, Object> model = new HashMap<>();
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
      e.printStackTrace();
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String name = req.getParameter("name");

    Date startDate;
    if (req.getParameter("startDate").isEmpty() || req.getParameter("startDate") == null) {
      startDate = new Date();
    } else {
      try {
        startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            .parse(req.getParameter("startDate"));
      } catch (ParseException e) {
        startDate = new Date();
      }
    }

    List<EventDto> events;
    if (req.getParameter("endDate").isEmpty() || req.getParameter("endDate") == null) {
      events = searchService.searchEventsByNameAndStartDate(name, startDate);
    } else {
      Date endDate;
      try {
        endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(req.getParameter("endDate"));
        events = searchService.searchEventsByNameAndDates(name, startDate, endDate);
      } catch (ParseException e) {
        events = searchService.searchEventsByNameAndStartDate(name, startDate);
      }
    }

    Template template = templateProvider.getTemplate(getServletContext(), "search.ftlh");

    Map<String, Object> model = new HashMap<>();
    model.put("events", events);
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

