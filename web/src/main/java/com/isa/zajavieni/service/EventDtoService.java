package com.isa.zajavieni.service;

import com.isa.zajavieni.dao.EventsDaoBean;
import com.isa.zajavieni.dto.EventDto;
import com.isa.zajavieni.entity.Event;
import com.isa.zajavieni.mapper.EventDtoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Date;
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
        Query query = entityManager.createNamedQuery("Event.upcomingEvents");

        query.setParameter("time", new Date())
                .setFirstResult(from)
                .setMaxResults(howMany);

        List<Event> resultList = query.getResultList();
        return resultList.stream()
                .map((event) -> dtoMapper.mapEventToDto(event))
                .collect(Collectors.toList());
    }

    private int getUpcomingEventsSize() {
        Query query = entityManager.createNamedQuery(Event.GET_SIZE);
        query.setParameter("time", new Date());
        Long result = (Long) query.getSingleResult();
        logger.info("{} events found", result);
        return result.intValue();
    }

    public int getTotalPages(int eventsPerPage) {
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

}
