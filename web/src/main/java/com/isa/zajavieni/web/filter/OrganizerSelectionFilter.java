package com.isa.zajavieni.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
