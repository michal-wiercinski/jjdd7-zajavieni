package com.isa.zajavieni.service.statistic;

import com.isa.zajavieni.dao.PopularityEventDaoBean;
import com.isa.zajavieni.entity.PopularityEvent;
import com.isa.zajavieni.entity.statisticapi.PopularityEventResponse;
import com.isa.zajavieni.mapper.apiMapper.PopularityEventMapper;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Stateless
public class PopularityEventApiService {

  @Inject
  private PopularityEventMapper popularityEventMapper;

  @Inject
  private PopularityEventDaoBean popularityEventDaoBean;

  @Transactional
  public List<PopularityEventResponse> getPopularityEventJsonObject() {
    List<PopularityEvent> popularityEvents = popularityEventDaoBean.getPopularityEvent();
    List<PopularityEventResponse> popularityEventResponses = new ArrayList<>();
    popularityEvents.forEach(popularityEvent -> {
      PopularityEventResponse popularityEventResponse = popularityEventMapper
          .mapPopularityEventEntityToApi(popularityEvent);
      popularityEventResponses.add(popularityEventResponse);
    });
    return popularityEventResponses;
  }
}
