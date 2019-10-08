package com.isa.zajavieni.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/loggers")
public class LoggerServlet extends HttpServlet {

  private Logger logger = LoggerFactory.getLogger(LoggerServlet.class.getName());

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    logger.debug("This is debug message");
    logger.info("This is info message");
    logger.trace("This is trace message");
    logger.warn("This is warn message");
    logger.error("This is error message");
    resp.getWriter().println("Logic executed successfully...");
  }
}
