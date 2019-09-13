package com.isa.zajavieni.servlet;

import com.isa.zajavieni.dto.EventSummary;
import com.isa.zajavieni.entity.Event;
import com.isa.zajavieni.provider.TemplateProvider;
import com.isa.zajavieni.service.DataParseService;
import com.isa.zajavieni.service.UpcomingEventService;
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
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet("/upcoming-events")
public class UpcomingEventServlet extends HttpServlet {

    private static final int EVENTS_PER_PAGE = 8;
    private static final String PAGE_NUMBER = "pageNo";

    @EJB
    private UpcomingEventService upcomingEventService;

    private Logger logger = LoggerFactory.getLogger(getClass().getName());
    @Inject
    private TemplateProvider templateProvider;
    private DataParseService parseService = new DataParseService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        LocalDate currentDate = LocalDate.now();
        int pageNumber = 0;
        int totalPages = upcomingEventService.getUpcomingEventsSize() / EVENTS_PER_PAGE;
        String pagepar = req.getParameter(PAGE_NUMBER);
        if(pagepar != null || !pagepar.isEmpty()){
            pageNumber = Integer.valueOf(pagepar);
        }
        List<EventSummary> events = upcomingEventService.findUpcomingEvents(pageNumber, EVENTS_PER_PAGE);

        Template template = templateProvider.getTemplate(getServletContext(), "upcoming-events.ftlh");
        Map<String, Object> model = new HashMap<>();
        model.put("date", currentDate);
        model.put("events", events);
        model.put("pageNumber", pageNumber);
        model.put("totalPages", totalPages);


        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.error(e.getMessage());
        }
    }

//    private List<Event> fetchEventsOnPage() {
//        int size = upcomingEventService.getUpcomingEventsSize();
//        int from = 5;
//        int to = from + EVENTS_PER_PAGE;
//        upcomingEventService.
//
//    }

}
