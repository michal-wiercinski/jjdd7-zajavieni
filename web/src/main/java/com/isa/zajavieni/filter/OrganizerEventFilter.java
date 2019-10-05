package com.isa.zajavieni.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(
    filterName = "OrganizerEventFilter",
    urlPatterns = {"/filter-by-organizer"}
)
public class OrganizerEventFilter implements Filter {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());
  private static final String PAGE_NUMBER = "pageNo";
  private static final String EVENT_ID = "id";


  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    Long id = null;
    String idParam = servletRequest.getParameter(EVENT_ID);
    if (NumberUtils.isDigits(idParam)) {
      id = Long.valueOf(idParam);
    } else {
      logger.warn("bad format id parameter: {}", idParam);
      HttpServletResponse httpResponse = (HttpServletResponse)servletResponse;
      httpResponse.sendRedirect("/error");
      return;
    }

    int pageNumber = 1;
    String pageParameter = servletRequest.getParameter(PAGE_NUMBER);
    if (pageParameter != null && !pageParameter.isEmpty() && NumberUtils.isDigits(pageParameter)) {
      pageNumber = Integer.valueOf(pageParameter);
    } else {
      logger.warn("bad format page number: {}", pageParameter);
      HttpServletResponse httpResponse = (HttpServletResponse)servletResponse;
      httpResponse.sendRedirect("/error");
      return;
    }

    servletRequest.setAttribute(PAGE_NUMBER, pageNumber);
    servletRequest.setAttribute(EVENT_ID, id);
    filterChain.doFilter(servletRequest, servletResponse);
  }
}
