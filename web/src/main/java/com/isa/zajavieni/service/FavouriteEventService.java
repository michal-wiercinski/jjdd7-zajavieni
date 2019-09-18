package com.isa.zajavieni.service;

import com.isa.zajavieni.dao.EventsDaoBean;
import com.isa.zajavieni.dto.EventDto;
import com.isa.zajavieni.entity.Event;
import com.isa.zajavieni.mapper.EventDtoMapper;
import com.isa.zajavieni.servlet.LoggerServlet;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class FavouriteEventService {

  private Logger logger = LoggerFactory.getLogger(LoggerServlet.class.getName());

  @Inject
  EventsDaoBean eventsDaoBean;

  @Inject
  private EventDtoMapper dtoMapper;

  public List<EventDto> findListOfFavouriteEvents() {
    logger.info("Find list of favourite events");
    List<Event> favouriteEvents = eventsDaoBean.findAllFavouriteEvents();
    return favouriteEvents.stream().map(event -> dtoMapper.mapEventToDto(event)).collect(Collectors.toList());
  }

  public void setEventFavouriteStatus(String idString) {
    logger.info("Set status of favourite");
    Long id = Long.parseLong(idString);
    Event searchingEvent = eventsDaoBean.findById(id);
    searchingEvent.setIsFavourite(!searchingEvent.getIsFavourite());
    eventsDaoBean.editEvent(searchingEvent);
  }
}

