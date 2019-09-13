package com.isa.zajavieni.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(
        filterName = "ContentTypeFilter",
        urlPatterns = {"/*"}
)
public class ContentTypeFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        String contentType = "text/html;charset=UTF-8";
        response.setContentType(contentType);
        filterChain.doFilter(request, response);
    }
}
