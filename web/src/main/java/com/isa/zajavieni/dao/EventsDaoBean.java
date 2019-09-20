package com.isa.zajavieni.dao;

import com.isa.zajavieni.entity.Event;
import com.isa.zajavieni.servlet.LoggerServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Stateless
public class EventsDaoBean {

    private Logger logger = LoggerFactory.getLogger(LoggerServlet.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public void editEvent(Event event) {
        logger.info("Object event id: {} merge to DB", event.getId());
        entityManager.merge(event);
    }

    public void saveEvent(Event event) {
        logger.info("Object event id: {} persist to DB", event.getId());
        entityManager.persist(event);
    }

    public List<Event> searchEvents(String phrase) {
        Query query = entityManager.createNamedQuery("Event.foundEvents");
        query.setParameter("phrase", phrase);
        return query.getResultList();
    }

    public Event findById(Long id) {
        logger.info("Object event id: {} has been found", id);
        return entityManager.find(Event.class, id);
    }

    public List<Event> findUpcomingEvents(int from, int howMany) {
        Query query = entityManager.createNamedQuery("Event.upcomingEvents");
        query.setParameter("time", new Date())
                .setFirstResult(from)
                .setMaxResults(howMany);
        return query.getResultList();
    }

    public int getUpcomingEventsSize() {
        Query query = entityManager.createNamedQuery("Event.counterByDate");
        query.setParameter("time", new Date());
        Long result = (Long) query.getSingleResult();
        return result.intValue();
    }

    public List<Event> findAllByOrganizerId(Long id, int from, int howMany) {
        Query query = entityManager.createNamedQuery("Event.filterByOrganizer");
        query.setParameter("id_organizer", id)
                .setParameter("time", new Date())
                .setFirstResult(from)
                .setMaxResults(howMany);
        return query.getResultList();
    }

    public int getOrganizersEventSize(Long id) {
        Query query = entityManager.createNamedQuery("Event.counterByOrganizer");
        query.setParameter("time", new Date())
                .setParameter("id_organizer", id);
        Long result = (Long) query.getSingleResult();
        return result.intValue();
    }
}

