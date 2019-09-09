package com.isa.zajavieni.dao;

import com.isa.zajavieni.Entity.Event;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EventsDaoBean {

  @PersistenceContext
  EntityManager entityManager;

  public void saveEvent(Event event) {
    entityManager.persist(event);
  }

}
