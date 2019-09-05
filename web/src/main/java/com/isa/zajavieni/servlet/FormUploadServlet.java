package com.isa.zajavieni.servlet;

import com.isa.zajavieni.provider.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/upload-file")
public class FormUploadServlet extends HttpServlet {


    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Template template = templateProvider.getTemplate(getServletContext(), "data-upload.ftlh");
        Map<String, Object> model = new HashMap<>();
        try {
            template.process(model, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
