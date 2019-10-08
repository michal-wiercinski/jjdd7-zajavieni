package com.isa.zajavieni.mapper.apiMapper;

import com.isa.zajavieni.entity.PopularityFavouriteEvent;
import com.isa.zajavieni.entity.statisticapi.PopularityFavouriteEventResponse;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

@Stateless
public class PopularityFavouriteEventMapper {

  @Transactional
  public PopularityFavouriteEventResponse mapPopularityFavouriteEventEntityToApi(
      PopularityFavouriteEvent popularityFavouriteEvent) {
    PopularityFavouriteEventResponse popularityFavouriteEventResponse = new PopularityFavouriteEventResponse();
    popularityFavouriteEventResponse
        .setFavouriteEventName(popularityFavouriteEvent.getEvent().getName());
    popularityFavouriteEventResponse.setQuantity(popularityFavouriteEvent.getQuantity());
    return popularityFavouriteEventResponse;
  }
}
