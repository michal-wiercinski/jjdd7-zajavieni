package com.isa.zajavieni.dao;

import com.isa.zajavieni.entity.Event;
import com.isa.zajavieni.servlet.LoggerServlet;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
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
    Query query = entityManager.createNamedQuery("Event.findFavouriteEvents");
    query.setParameter("id", id);
    return query.getResultList();
  }

  public List<Event> searchEvents(String phrase) {
    Query query = entityManager.createNamedQuery("Event.foundEvents");
    query.setParameter("phrase", "%" + phrase + "%");
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
    query.setParameter("organizerId", id)
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

  public List<Event> findAllFavouriteEvents() {
    Query query = entityManager.createNamedQuery("Event.findAllFavouriteEvents");
    return query.getResultList();
  }

  public void removeEvent(Event event) {
    logger.info("Object event id: {} remove from DB", event.getId());
    entityManager.remove(event);
  }

  public List<Event> findByNameAndDates(String name, Date startDate, Date endDate, int pageNumber) {
    Query query = entityManager.createNamedQuery("Event.findByNameAndDates");
    query
        .setParameter("name", "%" + name + "%")
        .setParameter("startDate", startDate, TemporalType.TIMESTAMP)
        .setParameter("endDate", endDate, TemporalType.TIMESTAMP)
        .setFirstResult(getFirstResultNumber(pageNumber))
        .setMaxResults(8);
    return query.getResultList();
  }

  private int getFirstResultNumber(int pageNumber) {
    return (pageNumber - 1) * 8;
  }

  public long getSizeEventsByNameAndDates(String name, Date startDate, Date endDate) {
    Query query = entityManager.createNamedQuery("Event.countFindByNameAndDates");
    query
        .setParameter("name", "%" + name + "%")
        .setParameter("startDate", startDate, TemporalType.TIMESTAMP)
        .setParameter("endDate", endDate, TemporalType.TIMESTAMP);
    return (long) query.getSingleResult();
  }

  public List<Event> findByNameAndStartDate(String name, Date startDate, int pageNumber) {
    Query query = entityManager.createNamedQuery("Event.findByNameAndStartDate");
    query
        .setParameter("name", "%" + name + "%")
        .setParameter("startDate", startDate, TemporalType.TIMESTAMP)
        .setFirstResult(getFirstResultNumber(pageNumber))
        .setMaxResults(8);
    return query.getResultList();
  }

  public long getSizeEventsByNameAndStartDate(String name, Date startDate) {
    Query query = entityManager.createNamedQuery("Event.countFindByNameAndStartDate");
    query
        .setParameter("name", "%" + name + "%")
        .setParameter("startDate", startDate, TemporalType.TIMESTAMP);
    return (long) query.getSingleResult();
  }

  public List<Event> findByNameAndEndDate(String name, Date endDate, int pageNumber) {
    Query query = entityManager.createNamedQuery("Event.findByNameAndEndDate");
    query
        .setParameter("name", "%" + name + "%")
        .setParameter("endDate", endDate, TemporalType.TIMESTAMP)
        .setFirstResult(getFirstResultNumber(pageNumber))
        .setMaxResults(8);
    return query.getResultList();
  }

  public long getSizeEventsByNameAndEndDate(String name, Date endDate) {
    Query query = entityManager.createNamedQuery("Event.countFindByNameAndEndDate");
    query
        .setParameter("name", "%" + name + "%")
        .setParameter("endDate", endDate, TemporalType.TIMESTAMP);
    return (long) query.getSingleResult();
  }

  public List<Event> findByName(String name, int pageNumber) {
    Query query = entityManager.createNamedQuery("Event.findByName");
    query
        .setParameter("name", "%" + name + "%")
        .setFirstResult(getFirstResultNumber(pageNumber))
        .setMaxResults(8);
    return query.getResultList();
  }

  public long getSizeEventsByName(String name) {
    Query query = entityManager.createNamedQuery("Event.countFindByName");
    query.setParameter("name", "%" + name + "%");
    return (long) query.getSingleResult();
  }

  public List<Event> findEventByOrganizerNameAndDates(String name, Date startDate, Date endDate,
      int pageNumber) {
    Query query = entityManager.createNamedQuery("Event.findByNameOrganizerAndDates");
    query
        .setParameter("name", "%" + name + "%")
        .setParameter("startDate", startDate, TemporalType.TIMESTAMP)
        .setParameter("endDate", endDate, TemporalType.TIMESTAMP)
        .setFirstResult(getFirstResultNumber(pageNumber))
        .setMaxResults(8);
    return query.getResultList();
  }

  public long getSizeEventByOrganizerNameAndDates(String name, Date startDate, Date endDate) {
    Query query = entityManager.createNamedQuery("Event.countByNameOrganizerAndDates");
    query
        .setParameter("name", "%" + name + "%")
        .setParameter("startDate", startDate, TemporalType.TIMESTAMP)
        .setParameter("endDate", endDate, TemporalType.TIMESTAMP);
    return (long) query.getSingleResult();
  }

  public List<Event> findEventByOrganizerNameAndStartDate(String name, Date startDate,
      int pageNumber) {
    Query query = entityManager.createNamedQuery("Event.findByNameOrganizerAndStartDate");
    query
        .setParameter("name", "%" + name + "%")
        .setParameter("startDate", startDate, TemporalType.TIMESTAMP)
        .setFirstResult(getFirstResultNumber(pageNumber))
        .setMaxResults(8);
    return query.getResultList();
  }

  public long getSizeEventByOrganizerNameAndStartDate(String name, Date startDate) {
    Query query = entityManager.createNamedQuery("Event.countByNameOrganizerAndStartDate");
    query
        .setParameter("name", "%" + name + "%")
        .setParameter("startDate", startDate, TemporalType.TIMESTAMP);
    return (long) query.getSingleResult();
  }

  public List<Event> findEventByOrganizerNameAndEndDate(String name, Date endDate, int pageNumber) {
    Query query = entityManager.createNamedQuery("Event.findByNameOrganizerAndEndDate");
    query
        .setParameter("name", "%" + name + "%")
        .setParameter("endDate", endDate, TemporalType.TIMESTAMP)
        .setFirstResult(getFirstResultNumber(pageNumber))
        .setMaxResults(8);
    return query.getResultList();
  }

  public long getSizeEventByOrganizerNameAndEndDate(String name, Date endDate) {
    Query query = entityManager.createNamedQuery("Event.countByNameOrganizerAndEndDate");
    query
        .setParameter("name", "%" + name + "%")
        .setParameter("endDate", endDate, TemporalType.TIMESTAMP);
    return (long) query.getSingleResult();
  }

  public List<Event> findEventByOrganizerName(String name, int pageNumber) {
    Query query = entityManager.createNamedQuery("Event.findByNameOrganizer");
    query
        .setParameter("name", "%" + name + "%")
        .setFirstResult(getFirstResultNumber(pageNumber))
        .setMaxResults(8);
    return query.getResultList();
  }

  public long getSizeEventByOrganizerName(String name) {
    Query query = entityManager.createNamedQuery("Event.countByNameOrganizer");
    query
        .setParameter("name", "%" + name + "%");
    return (long) query.getSingleResult();
  }
}