package com.isa.zajavieni.dao;

import com.isa.zajavieni.entity.Event;
import com.isa.zajavieni.servlet.LoggerServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
        query.setParameter("phrase",phrase);
        return query.getResultList();
    }

    public Event findById(Long id) {
        logger.info("Object event id: {} has been found", id);
        return entityManager.find(Event.class, id);
    }
}

