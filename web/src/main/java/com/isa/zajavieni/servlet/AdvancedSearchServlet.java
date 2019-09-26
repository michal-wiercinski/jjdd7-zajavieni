package com.isa.zajavieni.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isa.zajavieni.dto.EventDto;
import com.isa.zajavieni.provider.TemplateProvider;
import com.isa.zajavieni.service.SearchService;
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

@WebServlet("/advanced-search")
public class AdvancedSearchServlet extends HttpServlet {

  @Inject
  SearchService searchService;

  @Inject
  private TemplateProvider templateProvider;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    Template template = templateProvider
        .getTemplate(getServletContext(), "advanced-search.ftlh");
    Map<String, Object> model = new HashMap<>();
    try {
      template.process(model, resp.getWriter());
    } catch (TemplateException e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String name = req.getParameter("name");

    List<EventDto> events = new ArrayList<>();
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
    ObjectMapper objectMapper = new ObjectMapper();
    String json = objectMapper.writeValueAsString(events);
    resp.getWriter().println(json);

  }
}

