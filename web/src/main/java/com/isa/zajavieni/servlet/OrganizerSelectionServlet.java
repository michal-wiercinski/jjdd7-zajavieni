package com.isa.zajavieni.servlet;

import com.isa.zajavieni.dto.OrganizerDto;
import com.isa.zajavieni.provider.TemplateProvider;
import com.isa.zajavieni.service.OrganizerDtoService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.StringUtils;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/organizers")
public class OrganizerSelectionServlet extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @EJB
    OrganizerDtoService organizerDtoService;

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<OrganizerDto> organizers = new ArrayList<>();

        String letter;
        String letterParam = req.getParameter("letter");
        if (letterParam != null || !letterParam.isEmpty() || StringUtils.isAlpha(letterParam)) {
            letter = letterParam;
            organizers = organizerDtoService.getListByFirstLetter(letter);
        } else {
            organizers = organizerDtoService.getListByFirstLetter("A");
        }

        Template template = templateProvider.getTemplate(getServletContext(), "organizers-list.ftlh");
        Map<String, Object> model = new HashMap<>();
        model.put("organizers", organizers);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.error(e.getMessage());
        }
    }
}

