package com.isa.zajavieni.servlet;

import com.isa.zajavieni.dto.EventDto;
import com.isa.zajavieni.provider.TemplateProvider;
import com.isa.zajavieni.service.EventDtoService;
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
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/advanced-search")
public class AdvancedSearchServlet extends HttpServlet {

  @Inject
  private SearchService searchService;

  @EJB
  private EventDtoService eventDtoService;

  @Inject
  private TemplateProvider templateProvider;

  @Inject
  private FavouriteEventService favouriteEventService;

  private static final int EVENTS_PER_PAGE = 8;
  private static final String PAGE_NUMBER = "pageNo";
  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    if (req.getParameter("name") == null) {

      Template template = templateProvider
          .getTemplate(getServletContext(), "advanced-search.ftlh");
      Map<String, Object> model = new HashMap<>();
      try {
        template.process(model, resp.getWriter());
      } catch (TemplateException e) {
        e.printStackTrace();
      }

    } else {

      String name = req.getParameter("name");
      Date startDate;
      if (req.getParameter("startDate").isEmpty() || req.getParameter("startDate") == null) {
        startDate = new Date();
      } else {
        try {
          startDate = new SimpleDateFormat("yyyy-MM-dd")
              .parse(req.getParameter("startDate"));
        } catch (ParseException e) {
          logger.error("Parse error", e);
          resp.setStatus(400);
          return;
        }
      }

      List<EventDto> events;
      Date endDate = new Date();
      int pageNumber = 1;
      if (req.getParameter(PAGE_NUMBER) != null) {
        pageNumber = Integer.parseInt(req.getParameter(PAGE_NUMBER));
      }
      long totalPages = 0L;

      if (req.getParameter("endDate").isEmpty() || req.getParameter("endDate") == null) {
        events = searchService.searchEventsByNameAndStartDate(name, startDate);
      } else {
        try {
          endDate = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("endDate"));
          totalPages = eventDtoService.getSizeEventsByNameAndDates(name, startDate, endDate)
              / EVENTS_PER_PAGE;
          events = eventDtoService.searchEventsByNameAndDates(name, startDate, endDate, pageNumber);
        } catch (ParseException e) {
          logger.error("Parse error", e);
          resp.setStatus(400);
          return;
        }
      }

      Template template = templateProvider.getTemplate(getServletContext(), "search-result.ftlh");
      Map<String, Object> model = new HashMap<>();
      model.put("events", events);
      model.put("page", pageNumber);
      model.put("name", name);
      model.put("startDate", new SimpleDateFormat("yyyy-MM-dd").format(startDate));
      model.put("endDate", new SimpleDateFormat("yyyy-MM-dd").format(endDate));
      model.put("totalPages", totalPages);

      System.out.println(model);

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
}

