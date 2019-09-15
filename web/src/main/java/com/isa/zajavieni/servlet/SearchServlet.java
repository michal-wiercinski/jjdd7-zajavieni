package com.isa.zajavieni.servlet;

import com.isa.zajavieni.entity.Event;
import com.isa.zajavieni.service.SearchService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    @EJB
    private SearchService searchService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phrase = request.getParameter("phrase");
        List<Event> foundEvents = searchService.searchEvents(phrase);
        foundEvents.forEach(f-> System.out.println(f.getName()));
    }
}
