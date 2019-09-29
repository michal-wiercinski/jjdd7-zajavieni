package com.isa.zajavieni.dao;

import com.isa.zajavieni.entity.PopularityEvent;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class PopularityEventDaoBean {
  @PersistenceContext
  private EntityManager entityManager;

  public List<PopularityEvent> getPopularityEvent() {

    Query query = entityManager
        .createNamedQuery("PopularityEvent.findAll");

    return query.getResultList();
  }

  public void updatePopularityEventIncrementQuantity(Long id) {

    Query query = entityManager.createNamedQuery("PopularityEvent.incrementQuantity");
    query.setParameter("id", id).executeUpdate();
  }
}
