package com.isa.zajavieni.servlet;

import com.isa.zajavieni.dto.EventSummary;
import com.isa.zajavieni.provider.TemplateProvider;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());
    private static final int EVENETS_ON_THE_WELCOME = 8;

    @EJB
    private UpcomingEventService upcomingEventService;

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        List<EventSummary> events = upcomingEventService.findUpcomingEvents(0, EVENETS_ON_THE_WELCOME);
        Template template = templateProvider.getTemplate(getServletContext(), "welcome-page.ftlh");
        Map<String, Object> model = new HashMap<>();
        model.put("events", events);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.error(e.getMessage());
        }
    }
}
