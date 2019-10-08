package com.isa.zajavieni.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isa.zajavieni.dto.EventDto;
import com.isa.zajavieni.service.SearchService;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

  @EJB
  private SearchService searchService;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String phrase = request.getParameter("phrase");
    response.setContentType("application/json");
    List<EventDto> foundEvents = searchService.searchEvents(phrase);
    ObjectMapper objectMapper = new ObjectMapper();
    String json = objectMapper.writeValueAsString(foundEvents);
    response.getWriter().println(json);
  }
}
