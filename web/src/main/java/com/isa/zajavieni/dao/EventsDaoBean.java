package com.isa.zajavieni.dao;

import com.isa.zajavieni.entity.Event;
import com.isa.zajavieni.servlet.LoggerServlet;
import java.util.List;
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

  public List<Event> findAllUserFavouriteEvents(Long id) {
    Query query = entityManager.createNamedQuery("User.findUserFavouriteEvents");
    query.setParameter("id", id);
    return query.getResultList();
  }

    public Event findById(Long id) {
        logger.info("Object event id: {} has been found", id);
        return entityManager.find(Event.class, id);
    }
}

