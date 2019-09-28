package com.isa.zajavieni.service;

import com.isa.zajavieni.dao.EventsDaoBean;
import com.isa.zajavieni.dao.UserDaoBean;
import com.isa.zajavieni.dto.EventDto;
import com.isa.zajavieni.entity.Event;
import com.isa.zajavieni.entity.User;
import com.isa.zajavieni.mapper.EventDtoMapper;
import com.isa.zajavieni.servlet.LoggerServlet;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class FavouriteEventService {

  private Logger logger = LoggerFactory.getLogger(LoggerServlet.class.getName());

  @EJB
  private EventsDaoBean eventsDaoBean;

  @EJB
  private UserDaoBean userDaoBean;

  @EJB
  private EventDtoMapper dtoMapper;

  public List<EventDto> findListOfUserFavouriteEventsDto(Long id) {
    logger.info("Find list of favourite events");
    List<Event> favouriteEvents = eventsDaoBean.findAllUserFavouriteEvents(id).stream().sorted(
        Comparator.comparing(Event::getStartDate)).collect(Collectors.toList());
    return favouriteEvents.stream().map(event -> dtoMapper.mapEventToDto(event))
        .collect(Collectors.toList());
  }

  public List<Event> findListOfUserFavouriteEvents(Long id) {
    logger.info("Find list of favourite events");
    List<Event> favouriteEvents = eventsDaoBean.findAllUserFavouriteEvents(id);
    return favouriteEvents;
  }

  public List<Event> findListOfFavouriteEvents(){
    List<Event> favouriteEvents = eventsDaoBean.findAllFavouriteEvents();
    return favouriteEvents;
  }

  public void addEventToUserFavouriteEvents(String idEventString, String idUserString) {
    Long idEvent = Long.parseLong(idEventString);
    Long idUser = Long.parseLong(idUserString);
    Event searchingEvent = eventsDaoBean.findById(idEvent);
    EventDto searchingEventDto = dtoMapper.mapEventToDto(searchingEvent);
    if (findListOfUserFavouriteEvents(idUser).size() < 3 && !findListOfUserFavouriteEvents(idUser)
        .contains(searchingEvent)) {
      User user = userDaoBean.findById(idUser);
      user.getEvents().add(searchingEvent);
      searchingEvent.getUsers().add(user);
    }
    eventsDaoBean.editEvent(searchingEvent);
  }

  public void deleteEventFromUserFavouriteEvents(String idEventString, String idUserString) {
    Long idEvent = Long.parseLong(idEventString);
    Long idUser = Long.parseLong(idUserString);
    Event searchingEvent = eventsDaoBean.findById(idEvent);
    User user = userDaoBean.findById(idUser);
    user.getEvents().remove(searchingEvent);
    searchingEvent.getUsers().remove(user);
    eventsDaoBean.editEvent(searchingEvent);
  }

  public void displayFavouriteEventBeam(HttpServletRequest req, List<EventDto> favouriteEvents,
      Map<String, Object> model) {
    if (req.getSession().getAttribute("isVisible") == "true") {
      if (favouriteEvents.size() != 0) {
        EventDto upcomingEvent = favouriteEvents.stream().findFirst().get();
        model.put("upcomingEvent", upcomingEvent);
      }
    }
  }
}

