package com.isa.zajavieni;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loggers")
public class LoggerServlet extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(LoggerServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("This is debug message");
        logger.info("This is info message");
        logger.trace("This is trace message");
        logger.warn("This is warn message");
        logger.error("This is error message");
        resp.getWriter().println("Logic executed successfully...");
    }
}
