package com.isa.zajavieni.service;

import com.isa.zajavieni.dao.EventsDaoBean;
import com.isa.zajavieni.dao.UserDaoBean;
import com.isa.zajavieni.dto.EventDto;
import com.isa.zajavieni.entity.Event;
import com.isa.zajavieni.entity.User;
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
  private EventsDaoBean eventsDaoBean;

  @Inject
  private UserDaoBean userDaoBean;

  @Inject
  private EventDtoMapper dtoMapper;

  public List<EventDto> findListOfUserFavouriteEventsDto(Long id) {
    logger.info("Find list of favourite events");
    List<Event> favouriteEvents = eventsDaoBean.findAllUserFavouriteEvents(id);
    return favouriteEvents.stream().map(event -> dtoMapper.mapEventToDto(event))
        .collect(Collectors.toList());
  }

  public List<Event> findListOfUserFavouriteEvents(Long id) {
    logger.info("Find list of favourite events");
    List<Event> favouriteEvents = eventsDaoBean.findAllUserFavouriteEvents(id);
    return favouriteEvents;
  }

  public void addEventToUserFavouriteEvents(String idEventString, String idUserString){
    Long idEvent = Long.parseLong(idEventString);
    Long idUser = Long.parseLong(idUserString);
    Event searchingEvent = eventsDaoBean.findById(idEvent);
    EventDto searchingEventDto = dtoMapper.mapEventToDto(searchingEvent);
    if(findListOfUserFavouriteEvents(idUser).size() < 3 && !findListOfUserFavouriteEvents(idUser).contains(searchingEvent)){
      User user = userDaoBean.findById(idUser);
      user.getEvents().add(searchingEvent);
      searchingEvent.getUsers().add(user);
    }
    eventsDaoBean.editEvent(searchingEvent);
  }

  public void deleteEventFromUserFavouriteEvents(String idEventString, String idUserString){
    Long idEvent = Long.parseLong(idEventString);
    Long idUser = Long.parseLong(idUserString);
    Event searchingEvent = eventsDaoBean.findById(idEvent);
    User user = userDaoBean.findById(idUser);
    user.getEvents().remove(searchingEvent);
    searchingEvent.getUsers().remove(user);
    eventsDaoBean.editEvent(searchingEvent);
  }
}

