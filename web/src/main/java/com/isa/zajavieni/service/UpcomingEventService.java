package com.isa.zajavieni.service;

import com.isa.zajavieni.dto.EventSummary;
import com.isa.zajavieni.entity.Event;
import com.isa.zajavieni.mapper.EventSummaryMapper;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Stateless
public class UpcomingEventService {

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

    public int getUpcomingEventsSize() {
        Query query = entityManager.createNamedQuery(Event.GET_SIZE);
        query.setParameter("time", new Date());
        Long result = (Long) query.getSingleResult();
        return result.intValue();
    }
}
