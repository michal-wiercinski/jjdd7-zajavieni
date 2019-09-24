package com.isa.zajavieni.servlet;

import com.isa.zajavieni.dto.EventDto;
import com.isa.zajavieni.service.SearchService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/advanced-search")
public class AdvancedSearchServlet extends HttpServlet {

    @Inject
    SearchService searchService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        resp.setContentType("application/json");
        String startDate;
        if (req.getParameter("startDate").isEmpty()) {
            LocalDateTime now = LocalDateTime.now();
            startDate = now.toString();
        } else {
            startDate = req.getParameter("startDate");
        }
        if (req.getParameter("endDate").isEmpty()) {
            List<EventDto> events = searchService.searchEventsByNameAndStartDate(name, startDate);
        } else {
            String endDate = req.getParameter("endDate");
            searchService.searchEventsByNameAndDates(name, startDate, endDate);
        }


    }
}
