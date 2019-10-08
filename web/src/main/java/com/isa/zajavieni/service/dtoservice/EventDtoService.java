package com.isa.zajavieni.service.dtoservice;

import com.isa.zajavieni.dao.EventsDaoBean;
import com.isa.zajavieni.dao.UserDaoBean;
import com.isa.zajavieni.dto.BookingDto;
import com.isa.zajavieni.dto.EventDto;
import com.isa.zajavieni.entity.fromapi.Event;
import com.isa.zajavieni.entity.createdentity.User;
import com.isa.zajavieni.mapper.dtomapper.EventDtoMapper;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class EventDtoService {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @EJB
  private EventsDaoBean eventsDaoBean;

  @EJB
  private UserDaoBean userDaoBean;

  @EJB
  BookingService bookingService;

  @EJB
  private EventDtoMapper dtoMapper;

  @Transactional
  public List<EventDto> findUpcomingEvents(int from, int howMany) {

    from = formatFirstValue(from);
    if (from > 0) {
      from *= howMany;
    }
    List<EventDto> upcomingEventsList = eventsDaoBean.findUpcomingEvents(from, howMany)
        .stream()
        .map((event) -> dtoMapper.mapEventToDto(event))
        .collect(Collectors.toList());
    return upcomingEventsList;
  }

  private int formatFirstValue(int from) {
    if (from < 1) {
      from = 2;
    }
    return from -= 1;
  }

  private int getUpcomingEventsSize() {
    int size = eventsDaoBean.getUpcomingEventsSize();
    logger.info("{} events found", size);
    return size;
  }

  public int getTotalPagesUpcomingEvent(int eventsPerPage) {
    return getUpcomingEventsSize() / eventsPerPage;
  }

  public EventDto findById(Long id) {
    EventDto eventDto = dtoMapper.mapEventToDto(eventsDaoBean.findById(id));
    logger.info("Object event id: {} has been found", id);
    return eventDto;
  }

  public Event findEventById(Long id) {
    Event event = eventsDaoBean.findById(id);
    logger.info("Object event id: {} has been found", id);
    return event;
  }

  public List<EventDto> searchEvents(String phrase) {
    return eventsDaoBean.searchEvents(phrase).stream()
        .map((event) -> dtoMapper.mapEventToDto(event))
        .collect(Collectors.toList());
  }

  @Transactional
  public List<EventDto> findEventsByOrganizerId(Long id, int from, int howMany) {
    if (from > 0) {
      from *= howMany;
    }
    List<EventDto> eventsList = eventsDaoBean.findAllByOrganizerId(id, from, howMany).stream()
        .map((event) -> dtoMapper.mapEventToDto(event))
        .collect(Collectors.toList());
    logger.info("{} results have been found for the organizer for id: {}", eventsList.size(), id);
    return eventsList;
  }

  public int getOrganizersEventsSize(Long id) {
    int size = eventsDaoBean.getOrganizersEventSize(id);
    logger.info("{} events found", size);
    return size;
  }

  public int getTotalPagesOrganizersEvent(Long id, int perPage) {
    return getOrganizersEventsSize(id) / perPage;
  }

  public int getTotalPages(int numberFound, int perPage) {
    return numberFound / perPage;
  }

  public void deleteEventFromBase(Long id) {
    Event searchingEvent = findEventById(id);
    List<User> users = userDaoBean.findUsersWithFavouriteEvents(id);
    users.forEach(u -> u.getEvents().remove(searchingEvent));
    users.forEach(u -> searchingEvent.getUsers().remove(u));
    eventsDaoBean.removeEvent(searchingEvent);
  }

  public List<EventDto> searchEventsByNameAndDates(String name, Date startDate, Date endDate,
      int pageNumber) {
    return eventsDaoBean.findByNameAndDates(name, startDate, endDate, pageNumber).stream()
        .map((event) -> dtoMapper.mapEventToDto(event))
        .collect(Collectors.toList());
  }

  public long getSizeEventsByNameAndDates(String name, Date startDate, Date endDate) {
    return eventsDaoBean.getSizeEventsByNameAndDates(name, startDate, endDate);
  }

  public List<EventDto> searchEventsByNameAndStartDate(String name, Date startDate,
      int pageNumber) {
    return eventsDaoBean.findByNameAndStartDate(name, startDate, pageNumber).stream()
        .map((event) -> dtoMapper.mapEventToDto(event))
        .collect(Collectors.toList());
  }

  public long getSizeEventsByNameAndStartDate(String name, Date startDate) {
    return eventsDaoBean.getSizeEventsByNameAndStartDate(name, startDate);
  }

  public List<EventDto> searchEventsByNameAndEndDate(String name, Date endDate, int pageNumber) {
    return eventsDaoBean.findByNameAndEndDate(name, endDate, pageNumber).stream()
        .map((event) -> dtoMapper.mapEventToDto(event))
        .collect(Collectors.toList());
  }

  public long getSizeEventsByNameAndEndDate(String name, Date endDate) {
    return eventsDaoBean.getSizeEventsByNameAndEndDate(name, endDate);
  }

  public List<EventDto> searchEventsByName(String name, int pageNumber) {
    return eventsDaoBean.findByName(name, pageNumber).stream()
        .map((event) -> dtoMapper.mapEventToDto(event))
        .collect(Collectors.toList());
  }

  public long getSizeEventsByName(String name) {
    return eventsDaoBean.getSizeEventsByName(name);
  }

  public List<EventDto> searchEventByOrganizerNameAndDates(String name, Date startDate,
      Date endDate, int pageNumber) {
    return eventsDaoBean.findEventByOrganizerNameAndDates(name, startDate, endDate, pageNumber)
        .stream()
        .map((event) -> dtoMapper.mapEventToDto(event))
        .collect(Collectors.toList());
  }

  public long getSizeEventByOrganizerNameAndDates(String name, Date startDate, Date endDate) {
    return eventsDaoBean.getSizeEventByOrganizerNameAndDates(name, startDate, endDate);
  }

  public List<EventDto> searchEventByOrganizerNameAndStartDate(String name, Date startDate,
      int pageNumber) {
    return eventsDaoBean.findEventByOrganizerNameAndStartDate(name, startDate, pageNumber)
        .stream()
        .map((event) -> dtoMapper.mapEventToDto(event))
        .collect(Collectors.toList());
  }

  @Transactional
  public List<EventDto> getEventsByUserBooking(Long id) {
    List<BookingDto> bookings = bookingService.findBookingsForUser(id);
    return bookings.stream().map(b -> b.getEventDto()).collect(Collectors.toList());
  }

  public long getSizeEventByOrganizerNameAndStartDate(String name, Date startDate) {
    return eventsDaoBean.getSizeEventByOrganizerNameAndStartDate(name, startDate);
  }

  public List<EventDto> searchEventByOrganizerNameAndEndDate(String name, Date endDate,
      int pageNumber) {
    return eventsDaoBean.findEventByOrganizerNameAndEndDate(name, endDate, pageNumber)
        .stream()
        .map((event) -> dtoMapper.mapEventToDto(event))
        .collect(Collectors.toList());
  }

  public long getSizeEventByOrganizerNameAndEndDate(String name, Date endDate) {
    return eventsDaoBean.getSizeEventByOrganizerNameAndEndDate(name, endDate);
  }

  public List<EventDto> searchEventByOrganizerName(String name, int pageNumber) {
    return eventsDaoBean.findEventByOrganizerName(name, pageNumber)
        .stream()
        .map((event) -> dtoMapper.mapEventToDto(event))
        .collect(Collectors.toList());
  }

  public long getSizeEventByOrganizerName(String name) {
    return eventsDaoBean.getSizeEventByOrganizerName(name);
  }
}