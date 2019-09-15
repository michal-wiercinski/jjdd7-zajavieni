package com.isa.zajavieni.service;

import com.isa.zajavieni.dao.EventsDaoBean;
import com.isa.zajavieni.entity.Event;
import com.isa.zajavieni.servlet.LoggerServlet;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class FavouriteEventService {

  private Logger logger = LoggerFactory.getLogger(LoggerServlet.class.getName());

  @Inject
  EventsDaoBean eventsDaoBean;

  public List<Event> findListOfFavouriteEvents() {
    logger.info("Find list of favourite events");
    List<Event> favouriteEvents = eventsDaoBean.findAllFavouriteEvents();
    return favouriteEvents;
  }

  public void setEventFavouriteStatus(Long id) {
    logger.info("Set status of favourite");
    Event searchingEvent = eventsDaoBean.findEventById(id);
    searchingEvent.setIsFavourite(!searchingEvent.getIsFavourite());
    eventsDaoBean.editEvent(searchingEvent);
  }
}

