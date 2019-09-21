package com.isa.zajavieni.filter;

import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(
        filterName = "UpcomingEventsFilter",
        urlPatterns = {"/upcoming-events"}
)
public class UpcomingEventsFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(getClass().getName());
    private static final String PAGE_NUMBER = "pageNo";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {


        String pageParameter = servletRequest.getParameter(PAGE_NUMBER);

        int pageNumber = 0;
        if (pageParameter != null && !pageParameter.isEmpty()
                && NumberUtils.isDigits(pageParameter)) {
            pageNumber = Integer.valueOf(pageParameter);
        } else {
            logger.warn("Bad format");
        }

        servletRequest.setAttribute(PAGE_NUMBER, pageNumber);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}