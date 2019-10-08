package com.isa.zajavieni.web.servlet;

import com.isa.zajavieni.dto.EventDto;
import com.isa.zajavieni.entity.createdentity.UserType;
import com.isa.zajavieni.provider.TemplateProvider;
import com.isa.zajavieni.service.dtoservice.EventDtoService;
import com.isa.zajavieni.service.dtoservice.FavouriteEventService;
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

  private static final int EVENTS_PER_PAGE = 8;
  private static final String PAGE_NUMBER = "pageNo";

  private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @Inject
  private SearchService searchService;

  @EJB
  private EventDtoService eventDtoService;

  @Inject
  private TemplateProvider templateProvider;

  @Inject
  private FavouriteEventService favouriteEventService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String userType;
    if (req.getSession().getAttribute("userType") != null) {
      userType = String.valueOf(req.getSession().getAttribute("userType"));
    } else {
      userType = UserType.GUEST.name();
    }

    String name = req.getParameter("name");
    if (name == null || name.isEmpty()) {
      try {
        Template template = getTemplate("advanced-search.ftlh");
        Map<String, Object> model = new HashMap<>();
        model.put("type", userType);
        model.put("now", dateFormat.format(new Date()));
        Long userId = (Long) req.getSession().getAttribute("userId");
        if (userId != null) {
          List<EventDto> favouriteEvents = favouriteEventService
              .findListOfUserFavouriteEventsDto(userId);
          favouriteEventService.displayFavouriteEventBeam(req, favouriteEvents, model);
          model.put("userId", userId);
        }
        template.process(model, resp.getWriter());
        return;
      } catch (TemplateException e) {
        logger.error("Error rendering template", e);
        resp.setStatus(500);
        return;
      }
    }

    int pageNumber = 1;
    if (req.getParameter(PAGE_NUMBER) != null) {
      try {
        pageNumber = Integer.parseInt(req.getParameter(PAGE_NUMBER));
      } catch (NumberFormatException e) {
        resp.setStatus(400);
        return;
      }
    }

    Date startDate = null;
    String startDateString = req.getParameter("startDate");
    if (startDateString != null && !startDateString.isEmpty()) {
      try {
        startDate = dateFormat.parse(startDateString);
      } catch (ParseException e) {
        resp.setStatus(400);
        return;
      }
    }

    Date endDate = null;
    String endDateString = req.getParameter("endDate");
    if (endDateString != null && !endDateString.isEmpty()) {
      try {
        endDate = dateFormat.parse(endDateString);
      } catch (ParseException e) {
        resp.setStatus(400);
        return;
      }
    }

    String categorySearch = req.getParameter("categorySearch");
    if (categorySearch == null || categorySearch.isEmpty()) {
      resp.setStatus(400);
      return;
    }

    long totalPages;
    List<EventDto> events;

    if (categorySearch.equals("organizer")) {
      if (startDate == null && endDate == null) {
        long eventsNumber = eventDtoService.getSizeEventByOrganizerName(name);
        totalPages = eventsNumber / EVENTS_PER_PAGE;
        events = eventDtoService.searchEventByOrganizerName(name, pageNumber);
      } else if (startDate == null) {
        long eventsNumber = eventDtoService.getSizeEventByOrganizerNameAndEndDate(name, endDate);
        totalPages = eventsNumber / EVENTS_PER_PAGE;
        events = eventDtoService.searchEventByOrganizerNameAndEndDate(name, endDate, pageNumber);
      } else if (endDate == null) {
        long eventsNumber = eventDtoService
            .getSizeEventByOrganizerNameAndStartDate(name, startDate);
        totalPages = eventsNumber / EVENTS_PER_PAGE;
        events = eventDtoService
            .searchEventByOrganizerNameAndStartDate(name, startDate, pageNumber);
      } else {
        long eventsNumber = eventDtoService
            .getSizeEventByOrganizerNameAndDates(name, startDate, endDate);
        totalPages = eventsNumber / EVENTS_PER_PAGE;
        events = eventDtoService
            .searchEventByOrganizerNameAndDates(name, startDate, endDate, pageNumber);
      }
    } else if (categorySearch.equals("event")) {
      if (startDate == null && endDate == null) {
        long eventsNumber = eventDtoService.getSizeEventsByName(name);
        totalPages = eventsNumber / EVENTS_PER_PAGE;
        events = eventDtoService.searchEventsByName(name, pageNumber);
      } else if (startDate == null) {
        long eventsNumber = eventDtoService.getSizeEventsByNameAndEndDate(name, endDate);
        totalPages = eventsNumber / EVENTS_PER_PAGE;
        events = eventDtoService.searchEventsByNameAndEndDate(name, endDate, pageNumber);
      } else if (endDate == null) {
        long eventsNumber = eventDtoService.getSizeEventsByNameAndStartDate(name, startDate);
        totalPages = eventsNumber / EVENTS_PER_PAGE;
        events = eventDtoService.searchEventsByNameAndStartDate(name, startDate, pageNumber);
      } else {
        long eventsNumber = eventDtoService.getSizeEventsByNameAndDates(name, startDate, endDate);
        totalPages = eventsNumber / EVENTS_PER_PAGE;
        events = eventDtoService.searchEventsByNameAndDates(name, startDate, endDate, pageNumber);
      }
    } else {
      resp.setStatus(400);
      return;
    }

    if (events.isEmpty()) {
      Template template = getTemplate("advanced-search.ftlh");
      Map<String, Object> model = new HashMap<>();
      String message = "Brak wyników wyszukiwania. Spróbuj ponownie";
      model.put("type", userType);
      model.put("message", message);
      model.put("now", dateFormat.format(new Date()));
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
        logger.error("Error rendering template", e);
        resp.setStatus(500);
      }
      return;
    }

    Template template = getTemplate("search-result.ftlh");
    Map<String, Object> model = new HashMap<>();
    model.put("type", userType);
    model.put("events", events);
    model.put("page", pageNumber);
    model.put("name", name);
    model.put("categorySearch", categorySearch);
    model.put("startDate", startDate != null ? dateFormat.format(startDate) : "");
    model.put("endDate", endDate != null ? dateFormat.format(endDate) : "");
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
      logger.error("Error rendering template", e);
      resp.setStatus(500);
    }
  }

  private Template getTemplate(String template) throws IOException {
    return templateProvider.getTemplate(getServletContext(), template);
  }
}