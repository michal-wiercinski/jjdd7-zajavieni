package com.isa.zajavieni.servlet;

import com.isa.zajavieni.provider.TemplateProvider;
import freemarker.template.Template;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/upload-json-file")
public class UploadJsonFileServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "data-upload.ftlh");

    }

}
