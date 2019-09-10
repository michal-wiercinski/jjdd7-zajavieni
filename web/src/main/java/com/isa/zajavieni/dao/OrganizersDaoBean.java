package com.isa.zajavieni.dao;

import com.isa.zajavieni.Entity.Organizer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class OrganizersDaoBean {

  @PersistenceContext
  EntityManager entityManager;

  public void saveOrganizer(Organizer organizer) {
    entityManager.persist(organizer);
  }

  public Organizer findOrganizerById(Long id){
    return entityManager.find(Organizer.class, id);
  }

}
