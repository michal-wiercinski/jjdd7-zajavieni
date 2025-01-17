package com.isa.zajavieni.mapper.apiMapper;

import com.isa.zajavieni.entity.PopularityEvent;
import com.isa.zajavieni.entity.statisticapi.PopularityEventResponse;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

@Stateless
public class PopularityEventMapper {

  @Transactional
  public PopularityEventResponse mapPopularityEventEntityToApi(
      PopularityEvent popularityEvent) {
    PopularityEventResponse popularityEventResponse = new PopularityEventResponse();
    popularityEventResponse.setEventName(popularityEvent.getEvent().getName());
    popularityEventResponse.setQuantity(popularityEvent.getQuantity());
    return popularityEventResponse;
  }
}
