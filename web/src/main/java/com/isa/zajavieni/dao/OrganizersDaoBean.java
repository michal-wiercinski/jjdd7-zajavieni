package com.isa.zajavieni.dao;

import com.isa.zajavieni.entity.Organizer;
import com.isa.zajavieni.servlet.LoggerServlet;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class OrganizersDaoBean {

  private Logger logger = LoggerFactory.getLogger(LoggerServlet.class.getName());

  @PersistenceContext
  EntityManager entityManager;

  public void saveOrganizer(Organizer organizer) {
    logger.info("Object organizer persist to DB");
    entityManager.persist(organizer);
  }

  public Organizer findOrganizerById(Long id) {
    logger.info("Object organizer find");
    return entityManager.find(Organizer.class, id);
  }
}
