package com.isa.zajavieni.dao;

import com.isa.zajavieni.entity.Address;
import com.isa.zajavieni.web.servlet.LoggerServlet;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class AddressDaoBean {

  private Logger logger = LoggerFactory.getLogger(LoggerServlet.class.getName());

  @PersistenceContext
  EntityManager entityManager;

  public void savePlace(Address address) {
    logger.info("Object address id: {} persist to DB", address.getId());
    entityManager.persist(address);
  }

  public Address findAddressById(Long id) {
    logger.info("Object address id: {} find", id);
    return entityManager.find(Address.class, id);
  }
}
