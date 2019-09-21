package com.isa.zajavieni.dao;

import com.isa.zajavieni.entity.User;
import com.isa.zajavieni.servlet.LoggerServlet;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class UserDaoBean {

  private Logger logger = LoggerFactory.getLogger(LoggerServlet.class.getName());

  @PersistenceContext
  EntityManager entityManager;

  public User findById(Long id) {
    logger.info("Object event id: {} has been found", id);
    return entityManager.find(User.class, id);
  }

  public void saveEvent(User user) {
    logger.info("Object event id: {} persist to DB", user.getId());
    entityManager.persist(user);
  }

  public List<User> findUsersWithFavouriteEvents(Long id) {
    Query query = entityManager.createNamedQuery("User.findUsersWithFavouriteEvents");
    query.setParameter("id", id);
    return query.getResultList();
  }

}