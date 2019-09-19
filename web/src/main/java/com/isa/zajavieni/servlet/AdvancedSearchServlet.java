package com.isa.zajavieni.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isa.zajavieni.dto.EventDto;
import com.isa.zajavieni.provider.TemplateProvider;
import com.isa.zajavieni.service.SearchService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/advanced-search")
public class AdvancedSearchServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @EJB
    private SearchService searchService;

    private Logger logger = LoggerFactory.getLogger(AdvancedSearchServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Template template = templateProvider.getTemplate(getServletContext(), "advanced-search.ftlh");
        Map<String, Object> model = new HashMap<>();
        if (!req.getParameter("searchText").isEmpty() || req.getParameter("searchText")==null) {
            String phrase = req.getParameter("searchText");
            String startDateString = req.getParameter("startDate");
            String endDateString = req.getParameter("endDate");
            Date startDate = new Date(startDateString);
            Date endDate = new Date(endDateString);
            List<EventDto> foundEvents = searchService.searchEventsWithPhraseAndDates(phrase, startDate, endDate);
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(foundEvents);
            resp.getWriter().println(json);

            try {
                template.process(model, resp.getWriter());
            } catch (TemplateException e) {
                logger.warn(e.getMessage());
            }
        } else {


        }
    }
}