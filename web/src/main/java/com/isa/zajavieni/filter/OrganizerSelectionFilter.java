package com.isa.zajavieni.filter;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(
        filterName = "OrganizerSelectionFilter",
        urlPatterns = {"/organizers"}
)
public class OrganizerSelectionFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(getClass().getName());
    private static final String FIRST_LETTER = "letter";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {


        String letterParam = servletRequest.getParameter(FIRST_LETTER);
        String letter = null;
        if (letterParam != null && !letterParam.isEmpty()
                && StringUtils.isAlpha(letterParam) && (letterParam.length() == 1)) {
            letter = letterParam.toUpperCase();
        } else {
            letter = "A";
            logger.warn("Bad format");
        }

        servletRequest.setAttribute(FIRST_LETTER, letter);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
