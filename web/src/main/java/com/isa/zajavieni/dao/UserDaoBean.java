package com.isa.zajavieni.dao;

import com.isa.zajavieni.entity.Booking;
import com.isa.zajavieni.entity.User;
import com.isa.zajavieni.servlet.LoggerServlet;
import java.util.List;
import java.util.Optional;
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

  public List<User> findAll() {
    Query query = entityManager.createNamedQuery("User.findAll", User.class);
    return query.getResultList();
  }

  public void saveUser(User user) {
    logger.info("Object user id: {} persist to DB", user.getId());
    entityManager.persist(user);
  }

  public void updateUser(User user) {
    entityManager.merge(user);
  }

  public User findById(Long id) {
    logger.info("Object event id: {} has been found", id);
    return entityManager.find(User.class, id);
  }

  public Optional<User> findByEmail(String email) {
    logger.info("Object User: {} has been found", email);
    Query query = entityManager.createNamedQuery("User.findByEmail");
    query.setParameter("email", email);
    List<User> users = query.getResultList();
    if (users.isEmpty()) {
      logger.warn("User for email {} not found", email);
      return Optional.empty();
    }
    return Optional.of(users.get(0));
  }

  public List<User> findUsersWithFavouriteEvents(Long id) {
    Query query = entityManager.createNamedQuery("User.findWithFavouriteEvents");
    query.setParameter("id", id);
    return query.getResultList();
  }

}
