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
import java.util.stream.Collectors;

@Stateless
public class UpcomingEventService {

    @PersistenceContext
    EntityManager entityManager;

    public List<EventSummary> findUpcomingEvents() {

        Query query = entityManager.createNamedQuery("Event.upcomingEvents");
         query.setParameter("time", new Date());

        List<Event> resultList = query.setMaxResults(30).getResultList();
        return resultList.stream()
                 .map((event) -> new EventSummaryMapper().mapEventToDto(event))
                .collect(Collectors.toList());
    }
}
