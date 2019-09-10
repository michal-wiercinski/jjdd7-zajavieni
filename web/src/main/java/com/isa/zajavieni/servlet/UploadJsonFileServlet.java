package com.isa.zajavieni.servlet;

import com.isa.zajavieni.cdi.FileUploadProcessor;
import com.isa.zajavieni.exception.UserFileNotFound;
import com.isa.zajavieni.provider.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/admin/upload")
@MultipartConfig
public class UploadJsonFileServlet extends HttpServlet {

//    private static final Logger logger = Logger.getLogger(UploadJsonFileServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private FileUploadProcessor fileUploadProcessor;

    private Logger logger = LoggerFactory.getLogger(UploadJsonFileServlet.class);


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        Template template = templateProvider.getTemplate(getServletContext(), "data-upload.ftlh");
        Map<String, Object> model = new HashMap<>();
        try {
            template.process(model, response.getWriter());
        } catch (TemplateException e) {
            logger.warn(e.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Part json = request.getPart("file");
        String fileUrl = "";
        try {
            fileUrl = "files" + fileUploadProcessor.uploadJsonFile(json).getName();
        } catch (UserFileNotFound userFileNotFound) {
            logger.warn(userFileNotFound.getMessage());
        }
        response.getWriter().println("plik został dodany poprawnie " + fileUrl);
    }
}
