package com.isa.zajavieni.dao;

import com.isa.zajavieni.entity.PopularityFavouriteEvent;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class PopularityFavouriteEventDaoBean {
  @PersistenceContext
  private EntityManager entityManager;

  public List<PopularityFavouriteEvent> getPopularityFavouriteEvent() {

    Query query = entityManager
        .createNamedQuery("PopularityFavouriteEvent.findAll");

    return query.getResultList();
  }

  public void updatePopularityFavouriteEventIncrementQuantity(Long id) {

    Query query = entityManager.createNamedQuery("PopularityFavouriteEvent.incrementQuantity");
    query.setParameter("id", id).executeUpdate();
  }
}
