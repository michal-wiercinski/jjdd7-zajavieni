package com.isa.zajavieni.web.servlet;

import com.isa.zajavieni.provider.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/error")
public class ErrorHandlerServlet extends HttpServlet {

  @Inject
  TemplateProvider templateProvider;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    Template template = templateProvider.getTemplate(getServletContext(),"error-page.ftlh");

    PrintWriter printWriter = resp.getWriter();

    Map<String, String> model = new HashMap<>();

    try {
      template.process(model, printWriter);
    } catch (TemplateException e) {
      e.printStackTrace();
    }
  }
}

