package com.isa.zajavieni.dao;

import com.isa.zajavieni.entity.createdentity.PopularityFavouriteEvent;
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
    return query.setMaxResults(5).getResultList();
  }

  public void updatePopularityFavouriteEventIncrementQuantity(Long id) {
    Query query = entityManager.createNamedQuery("PopularityFavouriteEvent.incrementQuantity");
    query.setParameter("id", id).executeUpdate();
  }
}
