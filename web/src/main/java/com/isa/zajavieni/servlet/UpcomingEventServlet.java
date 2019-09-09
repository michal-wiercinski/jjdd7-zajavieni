package com.isa.zajavieni.servlet;

import com.isa.zajavieni.jsonclasses.Event;
import com.isa.zajavieni.provider.TemplateProvider;
import com.isa.zajavieni.service.DataParseService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet("/upcoming-events")
public class UpcomingEventServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());
    @Inject
    private TemplateProvider templateProvider;
    private DataParseService parseService = new DataParseService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        LocalDate currentDate = LocalDate.now();
        LocalDate endDate = currentDate.plusWeeks(1);
        parseService.parsePlaces("/home/mwiercinski/jjdd7-zajavieni/places.json");
        List<Event> events = parseService.parseEvents("/home/mwiercinski/jjdd7-zajavieni/new_base.json")
                .stream()
                .filter(e -> {
                    LocalDate eventDate = e.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    return eventDate.isBefore(currentDate.minusDays(1));
                }).limit(30)
                .collect(Collectors.toList());
        Template template = templateProvider.getTemplate(getServletContext(), "upcoming-events.ftlh");
        Map<String, Object> model = new HashMap<>();
        model.put("date", currentDate);
        model.put("events", events);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.error(e.getMessage());
        }
    }

}
