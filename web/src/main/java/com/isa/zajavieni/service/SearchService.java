package com.isa.zajavieni.service;

import com.isa.zajavieni.dto.EventDto;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class SearchService {

  @EJB
  private EventDtoService eventDtoService;

  public List<EventDto> searchEvents(String phrase) {
    return eventDtoService.searchEvents(phrase);
  }

  public List<EventDto> searchEventsByNameAndStartDate(String name, Date startDate) {
    return eventDtoService.searchEventsByNameAndStartDate(name, startDate);
  }

  public List<EventDto> searchEventsByNameAndDates(String name, Date startDate, Date endDate) {
    return eventDtoService.searchEventsByNameAndDates(name, startDate, endDate);
  }
}
