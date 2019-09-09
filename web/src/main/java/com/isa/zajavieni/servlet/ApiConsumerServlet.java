package com.isa.zajavieni.servlet;

import com.isa.zajavieni.Entity.Event;
import com.isa.zajavieni.parser.DataParseService;
import com.isa.zajavieni.service.EventApiConsumer;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/api")
public class ApiConsumerServlet extends HttpServlet {

  @Inject
  private EventApiConsumer eventApiConsumer;

  @Inject
  private DataParseService dataParseService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    PrintWriter writer = resp.getWriter();

    writer.println(eventApiConsumer.consume());
    writer.println(dataParseService.parseEvents(
        "/home/hp/jjdd7-zajavieni/events.json"));
  }

}
