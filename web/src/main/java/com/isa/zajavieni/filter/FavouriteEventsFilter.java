package com.isa.zajavieni.filter;

import com.isa.zajavieni.dto.EventDto;
import com.isa.zajavieni.service.EventDtoService;
import com.isa.zajavieni.service.FavouriteEventService;
import com.isa.zajavieni.servlet.LoggerServlet;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.HttpMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(
    filterName = "FavouriteEventsFilter",
    urlPatterns = {"/favourite-events"}
)
public class FavouriteEventsFilter implements Filter {

  private Logger logger = LoggerFactory.getLogger(LoggerServlet.class.getName());

  private final int maxNumberOfFavouriteEvents = 3;

  @Inject
  FavouriteEventService favouriteEventService;

  @Inject
  EventDtoService eventDtoService;

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
    HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
    if (httpServletRequest.getMethod().equalsIgnoreCase(HttpMethod.PUT)) {
      Long id = Long.parseLong(httpServletRequest.getParameter("id"));
      List<EventDto> favouriteEventsList = favouriteEventService.findListOfFavouriteEvents();
      if (favouriteEventsList.size() == maxNumberOfFavouriteEvents
          && eventDtoService.findById(id) != null
          && eventDtoService.findById(id).isFavourite() == false) {
        logger.warn("Max numbers of favourite events");
        httpServletResponse
            .sendError(1, "Lista wydarzeń ulubionych przekroczyła maksymalną liczbę 3.");
      }
    }
    filterChain.doFilter(httpServletRequest, httpServletResponse);
  }
}


