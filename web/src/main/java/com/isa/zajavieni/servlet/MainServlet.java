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

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(getClass().getName());
    @Inject
    private TemplateProvider templateProvider;
    private DataParseService parseService = new DataParseService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        LocalDate currentDate = LocalDate.now();
        parseService.parsePlaces("/home/annaossowska/zajavieni/jjdd7-zajavieni/places.json");
        List<Event> events = parseService
                .parseEvents("/home/annaossowska/zajavieni/jjdd7-zajavieni/new_base.json")
                .stream()
                .filter(e -> {
                    LocalDate eventDate = e.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    return eventDate.equals(currentDate);
                }).limit(8)
                .collect(Collectors.toList());
        Template template = templateProvider.getTemplate(getServletContext(), "welcome-page.ftlh");
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
