package com.isa.zajavieni.service.statistic;

import com.isa.zajavieni.dao.PopularityEventDaoBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class PopularityEventService {

  @Inject
  private PopularityEventDaoBean popularityEventDaoBean;

  public void incrementQuantityPopularityEvent(Long id) {
    popularityEventDaoBean.updatePopularityEventIncrementQuantity(id);
  }

}
