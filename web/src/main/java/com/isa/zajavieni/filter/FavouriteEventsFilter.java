package com.isa.zajavieni.filter;

import com.isa.zajavieni.entity.Event;
import com.isa.zajavieni.service.EventService;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*
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
  EventService eventService;

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
    HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
    Long id = Long.parseLong(httpServletRequest.getParameter("event_id"));
    List<Event> favouriteEventsList = favouriteEventService.findListOfFavouriteEvents();
    if(favouriteEventsList.size() < maxNumberOfFavouriteEvents && eventService.findEventById(id) != null) {
      filterChain.doFilter(httpServletRequest, httpServletResponse);
    } else{
      logger.info("Max numbers of favourite events");
      httpServletResponse.sendError(1,"Lista wydarzeń ulubionych przekroczyła maksymalną liczbę.");
    }
  }
}

 */
