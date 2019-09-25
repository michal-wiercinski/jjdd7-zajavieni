package com.isa.zajavieni.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(
    filterName = "FavouriteEventBeamFilter",
    urlPatterns = {"/*"}
)
public class FavouriteEventBeamFilter implements Filter {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
    HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
    if(httpServletRequest.getSession().getAttribute("isVisible")==null){
      httpServletRequest.getSession().setAttribute("isVisible","visible");
    }
    filterChain.doFilter(httpServletRequest, httpServletResponse);
  }
}
