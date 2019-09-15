package com.isa.zajavieni.service;

import com.isa.zajavieni.dto.EventSummary;
import com.isa.zajavieni.entity.Event;
import com.isa.zajavieni.mapper.EventSummaryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class EventSummaryService {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());
    @PersistenceContext
    EntityManager entityManager;

    public List<EventSummary> findUpcomingEvents(int from, int howMany) {
        Query query = entityManager.createNamedQuery("Event.upcomingEvents");

        query.setParameter("time", new Date())
                .setFirstResult(from)
                .setMaxResults(howMany);

        List<Event> resultList = query.getResultList();
        return resultList.stream()
                .map((event) -> new EventSummaryMapper().mapEventToDto(event))
                .collect(Collectors.toList());
    }

    private int getUpcomingEventsSize() {
        Query query = entityManager.createNamedQuery(Event.GET_SIZE);
        query.setParameter("time", new Date());
        Long result = (Long) query.getSingleResult();
        return result.intValue();
    }

    public int getTotalPages(int eventsPerPage) {
        return getUpcomingEventsSize() / eventsPerPage;
    }

    public EventSummary findById(Long id) {
        logger.info("Object event id: {} has been found", id);
        return entityManager.find(EventSummary.class, id);
    }

}
