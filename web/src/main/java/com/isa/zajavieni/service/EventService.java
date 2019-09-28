package com.isa.zajavieni.service;

import com.isa.zajavieni.dao.EventsDaoBean;
import com.isa.zajavieni.dto.BookingDto;
import com.isa.zajavieni.dto.EventDto;
import com.isa.zajavieni.entity.Event;
import com.isa.zajavieni.mapper.dtoMapper.EventDtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class EventService {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @EJB
  EventsDaoBean eventsDaoBean;

  @EJB
  BookingService bookingService;

  @Inject
  private EventDtoMapper dtoMapper;

  public void editEventDto(EventDto event){
    eventsDaoBean.editEvent(dtoMapper.mapDtoToEntity(event));
  }

  public void editEvent(Event event){
    eventsDaoBean.editEvent(event);
  }

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
    if(from < 1){
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

  @Transactional
  public List<EventDto> getEventsByUserBooking(Long id){
    List<BookingDto> bookings = bookingService.findBookingsForUser(id);
    List<Long> eventsId = bookings.stream().map(b -> b.getEventDto().getId()).collect(
        Collectors.toList());

    return eventsId.stream().map(event -> findById(id)).collect(
        Collectors.toList());
  }
}
