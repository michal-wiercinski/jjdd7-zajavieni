package com.isa.zajavieni.service;

import com.isa.zajavieni.dao.EventsDaoBean;
import com.isa.zajavieni.dto.EventDto;
import com.isa.zajavieni.mapper.EventDtoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class EventDtoService {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @PersistenceContext
    EntityManager entityManager;

    @EJB
    EventsDaoBean eventsDaoBean;

    @Inject
    private EventDtoMapper dtoMapper;

    @Transactional
    public List<EventDto> findUpcomingEvents(int from, int howMany) {
        List<EventDto> upcomingEventsList = eventsDaoBean.findUpcomingEvents(from,howMany)
                .stream()
                .map((event) -> dtoMapper.mapEventToDto(event))
                .collect(Collectors.toList());
        return upcomingEventsList;
    }

    private int getUpcomingEventsSize() {
        int size = eventsDaoBean.getUpcomingEventsSize();
        logger.info("{} events found", size);
        return size;
    }

    public int getTotalPages(int eventsPerPage) {
        return getUpcomingEventsSize() / eventsPerPage;
    }

    public EventDto findById(Long id) {
        EventDto eventDto = dtoMapper.mapEventToDto(eventsDaoBean.findById(id));
        logger.info("Object event id: {} has been found", id);
        return eventDto;
    }

    public List<EventDto> findEventsByOrganizerId(Long id){
        List<EventDto> eventsList = eventsDaoBean.findAllByOrganizerId(id).stream()
                .map((event) -> dtoMapper.mapEventToDto(event))
                .collect(Collectors.toList());
        logger.info("{} results have been found for the organizer for id: {}", eventsList.size(), id);
        return eventsList;
    }

}
