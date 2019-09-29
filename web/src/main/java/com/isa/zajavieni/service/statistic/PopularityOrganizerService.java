package com.isa.zajavieni.service.statistic;

import com.isa.zajavieni.dao.PopularityOrganizerDaoBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class PopularityOrganizerService {

  @Inject
  private PopularityOrganizerDaoBean popularityOrganizerDaoBean;

  public void incrementQuantityPopularityEvent(Long id) {
    popularityOrganizerDaoBean.updatePopularityOrganizerIncrementQuantity(id);
  }
}
