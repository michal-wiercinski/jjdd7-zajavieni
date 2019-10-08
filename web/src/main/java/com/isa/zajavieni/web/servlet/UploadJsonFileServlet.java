package com.isa.zajavieni.web.servlet;

import com.isa.zajavieni.entity.createdentity.UserType;
import com.isa.zajavieni.provider.TemplateProvider;
import com.isa.zajavieni.service.PartService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/admin/upload")
@MultipartConfig
public class UploadJsonFileServlet extends HttpServlet {

  @Inject
  private TemplateProvider templateProvider;

  @Inject
  private PartService partService;

  private Logger logger = LoggerFactory.getLogger(UploadJsonFileServlet.class);

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    Template template = templateProvider.getTemplate(getServletContext(), "data-upload.ftlh");
    Map<String, Object> model = new HashMap<>();
    String userType;
    if (!(request.getSession().getAttribute("userType") == null)) {
      userType = String.valueOf(request.getSession().getAttribute("userType"));
      model.put("type", userType);
    } else {
      userType = UserType.GUEST.name();
      model.put("type", userType);
    }
    try {
      template.process(model, response.getWriter());
    } catch (TemplateException e) {
      logger.warn(e.getMessage());
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    Part eventFile = request.getPart("eventFile");
    Part placeFile = request.getPart("placeFile");
    Part organizerFile = request.getPart("organizerFile");
    partService.servicedEventPart(eventFile);
    partService.servicedPlacePart(placeFile);
    partService.servicedOrganizerPart(organizerFile);
    response.sendRedirect("/main");
  }
}
