package com.isa.zajavieni.servlet;

import com.isa.zajavieni.dao.EventsDaoBean;
import com.isa.zajavieni.dto.EventDto;
import com.isa.zajavieni.entity.Address;
import com.isa.zajavieni.entity.Attachment;
import com.isa.zajavieni.entity.Category;
import com.isa.zajavieni.entity.Event;
import com.isa.zajavieni.entity.MediaLink;
import com.isa.zajavieni.entity.Organizer;
import com.isa.zajavieni.entity.User;
import com.isa.zajavieni.jsonclasses.TicketType;
import com.isa.zajavieni.provider.TemplateProvider;
import com.isa.zajavieni.service.FavouriteEventService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

  @Inject
  private EventsDaoBean eventsDaoBean;

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

    try {
      template.process(model, resp.getWriter());
    } catch (TemplateException e) {
      logger.error(e.getMessage());
    }








//    Category category =  new Category();
//    MediaLink mediaLink = new MediaLink();
//    TicketType ticketType = null;
//    Organizer organizer = new Organizer();



//    Event event = new Event();
//    event.setName("dupa");
//    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy (HH:mm)");
//    String dateInString = "27.09.2019 (23:50)";
//    try {
//      Date date = sdf.parse(dateInString);
//      event.setStartDate(date);
//    } catch (ParseException e) {
//      e.printStackTrace();
//    }
//    event.setId(99999L);
//    event.setActive(true);
//    event.setDescLong("aaaaaa");
//    event.setDescShort("aaaaaa");
//    String date2InString = "29.09.2019 (20:30)";
//    try {
//      Date date = sdf.parse(date2InString);
//      event.setEndDate(date);
//    } catch (ParseException e) {
//      e.printStackTrace();
//    }
//    event.setUsers(null);
//    event.setAddress(null);
//    event.setAttachment(null);
//    event.setCategory(category);
//    event.setType(ticketType);
//    event.setOrganizer(organizer);
//    event.setMediaLink(mediaLink);
//    eventsDaoBean.editEvent(event);
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
