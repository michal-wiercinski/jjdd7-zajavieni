package com.isa.zajavieni.dao;

import com.isa.zajavieni.entity.Organizer;
import com.isa.zajavieni.web.servlet.LoggerServlet;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class OrganizersDaoBean {

  private Logger logger = LoggerFactory.getLogger(LoggerServlet.class.getName());

  @PersistenceContext
  EntityManager entityManager;

  public void saveOrganizer(Organizer organizer) {
    logger.info("Object organizer id: {} persist to DB", organizer.getId());
    entityManager.persist(organizer);
  }

  public Organizer findOrganizerById(Long id) {
    logger.info("Object organizer id: {} find", id);
    return entityManager.find(Organizer.class, id);
  }

  public List<Organizer> findOrganizersByFirstLetter(String letter) {
    Query query = entityManager.createNamedQuery("Organizer.SearchByFirstLetter");
    query.setParameter("first_letter", letter);
    return query.getResultList();
  }
}
