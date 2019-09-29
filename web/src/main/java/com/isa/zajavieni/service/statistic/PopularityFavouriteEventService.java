package com.isa.zajavieni.service.statistic;

import com.isa.zajavieni.dao.PopularityFavouriteEventDaoBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class PopularityFavouriteEventService {

  @Inject
  private PopularityFavouriteEventDaoBean popularityFavouriteEventDaoBean;

  public void incrementQuantityPopularityEvent(Long id) {
    popularityFavouriteEventDaoBean.updatePopularityFavouriteEventIncrementQuantity(id);
  }

}
