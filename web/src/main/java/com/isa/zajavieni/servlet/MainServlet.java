package com.isa.zajavieni.servlet;

import com.isa.zajavieni.dto.EventDto;
import com.isa.zajavieni.provider.TemplateProvider;
import com.isa.zajavieni.service.EventDtoService;
import com.isa.zajavieni.service.UserService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());
  private static final int EVENTS_PER_PAGE = 8;
  private static final int FIRST_ELEMENT = 0;

  @EJB
  private EventDtoService eventDtoService;

  @EJB
  private UserService userService;

  @Inject
  private TemplateProvider templateProvider;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    String userType;

    List<EventDto> events = eventDtoService.findUpcomingEvents(FIRST_ELEMENT, EVENTS_PER_PAGE);
    Template template = templateProvider.getTemplate(getServletContext(), "welcome-page.ftlh");
    Map<String, Object> model = new HashMap<>();
    model.put("events", events);
    if(!(req.getSession().getAttribute("user_type") == null)){
      userType = String.valueOf(req.getSession().getAttribute("user_type"));
      model.put("type", userType);
    }else{
      userType = "QUEST";
      model.put("type", userType);
    }

    try {
      template.process(model, resp.getWriter());
    } catch (TemplateException e) {
      logger.error(e.getMessage());
    }
  }
}
