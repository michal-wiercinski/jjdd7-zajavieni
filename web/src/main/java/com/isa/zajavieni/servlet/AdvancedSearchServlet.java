package com.isa.zajavieni.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isa.zajavieni.dto.EventDto;
import com.isa.zajavieni.service.SearchService;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String name = req.getParameter("name");
    resp.setContentType("application/json");

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
      Date endDate = null;
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
