package com.isa.zajavieni.servlet;

import com.isa.zajavieni.jsonclasses.Event;
import com.isa.zajavieni.provider.TemplateProvider;
import com.isa.zajavieni.repository.EventList;
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

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(getClass().getName());
    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalDate currentDate = LocalDate.now();

        List<Event> events = new DataParseService().parseEvents("/home/mwiercinski/jjdd7-zajavieni/events.json")
                .stream()
                .filter(e -> {
                    LocalDate eventDate = e.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    return eventDate.equals(currentDate);
                }).collect(Collectors.toList());

        Template template = templateProvider.getTemplate(getServletContext(), "card-of-event.ftlh");
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
