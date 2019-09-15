package com.isa.zajavieni.dao;

import com.isa.zajavieni.entity.Event;
import com.isa.zajavieni.servlet.LoggerServlet;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

  public List<Event> findAllFavouriteEvents(){
    Query query = entityManager.createNamedQuery("User.findFavouriteEvents");
    return  query.getResultList();
  }

  public Event findEventById(Long id){
    logger.info("Find event id: {}", id);
    Event event = entityManager.find(Event.class, id);
    return event;
  }
}

