package com.isa.zajavieni.servlet;

import com.isa.zajavieni.dao.UserDaoBean;
import com.isa.zajavieni.dto.EventDto;
import com.isa.zajavieni.entity.User;
import com.isa.zajavieni.entity.UserType;
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

  @Inject
  private UserDaoBean userDaoBean;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    logger.info("Request GET method");
    Long idUser = 2L;
    List<EventDto> favouriteEvents = favouriteEventService.findListOfUserFavouriteEventsDto(idUser);
    Template template = templateProvider.getTemplate(getServletContext(), "favourite.ftlh");
    Map<String, Object> model = new HashMap<>();
    model.put("favouriteEvents", favouriteEvents);
    try {
      template.process(model, resp.getWriter());
    } catch (TemplateException e) {
      logger.error(e.getMessage());
    }
    if(userDaoBean.findById(2L) == null){
      User user = new User();
      user.setUserType(UserType.USER);
      userDaoBean.saveEvent(user);

      User user1 = new User();
      user1.setUserType(UserType.USER);
      userDaoBean.saveEvent(user1);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    logger.info("Request POST method");
    String idEvent = req.getParameter("id");
    String idUser = "2";
    favouriteEventService.addEventToUserFavouriteEvents(idEvent, idUser);
  }

  @Override
  protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    logger.info("Request DELETE method");
    String idEvent = req.getParameter("id");
    String idUser = "2";
    favouriteEventService.deleteEventFromUserFavouriteEvents(idEvent, idUser);
  }
}
