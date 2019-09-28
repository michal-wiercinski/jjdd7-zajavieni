package com.isa.zajavieni.servlet;

import com.isa.zajavieni.dao.UserDaoBean;
import com.isa.zajavieni.dto.EventDto;
import com.isa.zajavieni.dto.OrganizerDto;
import com.isa.zajavieni.entity.UserType;
import com.isa.zajavieni.provider.TemplateProvider;
import com.isa.zajavieni.service.FavouriteEventService;
import com.isa.zajavieni.service.OrganizerDtoService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet("/organizers")
public class OrganizerSelectionServlet extends HttpServlet {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @EJB
  OrganizerDtoService organizerDtoService;

  @Inject
  private TemplateProvider templateProvider;

  @Inject
  UserDaoBean userDaoBean;

  @Inject
  private FavouriteEventService favouriteEventService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    List<OrganizerDto> organizers = new ArrayList<>();
    String letter = req.getParameter("letter");
    organizers = organizerDtoService.getListByFirstLetter(letter.toUpperCase());
    Template template = templateProvider.getTemplate(getServletContext(), "organizers-list.ftlh");
    Map<String, Object> model = new HashMap<>();
    model.put("organizers", organizers);
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

    try {
      template.process(model, resp.getWriter());
    } catch (TemplateException e) {
      logger.error(e.getMessage());
    }
  }
}