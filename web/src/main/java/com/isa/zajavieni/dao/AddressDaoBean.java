package com.isa.zajavieni.dao;

import com.isa.zajavieni.Entity.Address;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AddressDaoBean {

  @PersistenceContext
  EntityManager entityManager;

  public void savePlace(Address address) {
    entityManager.persist(address);
  }

}
