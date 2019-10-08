package com.isa.zajavieni.dao;

import com.isa.zajavieni.entity.createdentity.PopularityOrganizer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class PopularityOrganizerDaoBean {

  @PersistenceContext
  private EntityManager entityManager;

  public List<PopularityOrganizer> getPopularityOrganizer() {
    Query query = entityManager
        .createNamedQuery("PopularityOrganizer.findAll");
    return query.setMaxResults(10).getResultList();
  }

  public void updatePopularityOrganizerIncrementQuantity(Long id) {
    Query query = entityManager.createNamedQuery("PopularityOrganizer.incrementQuantity");
    query.setParameter("id", id).executeUpdate();
  }
}
