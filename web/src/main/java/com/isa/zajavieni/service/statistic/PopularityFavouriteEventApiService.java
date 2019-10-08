package com.isa.zajavieni.service.statistic;

import com.isa.zajavieni.dao.PopularityFavouriteEventDaoBean;
import com.isa.zajavieni.entity.PopularityFavouriteEvent;
import com.isa.zajavieni.entity.statisticapi.PopularityFavouriteEventResponse;
import com.isa.zajavieni.mapper.apiMapper.PopularityFavouriteEventMapper;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jdo.annotations.Transactional;

@Stateless
public class PopularityFavouriteEventApiService {

  @Inject
  private PopularityFavouriteEventMapper popularityFavouriteEventMapper;

  @Inject
  private PopularityFavouriteEventDaoBean popularityFavouriteEventDaoBean;

  @Transactional
  public List<PopularityFavouriteEventResponse> getPopularityFavouriteEventJsonObject() {
    List<PopularityFavouriteEvent> popularityFavouriteEvents = popularityFavouriteEventDaoBean
        .getPopularityFavouriteEvent();
    List<PopularityFavouriteEventResponse> popularityFavouriteEventResponses = new ArrayList<>();
    popularityFavouriteEvents.forEach(popularityFavouriteEvent -> {
      PopularityFavouriteEventResponse popularityFavouriteEventResponse = popularityFavouriteEventMapper
          .mapPopularityFavouriteEventEntityToApi(popularityFavouriteEvent);
      popularityFavouriteEventResponses.add(popularityFavouriteEventResponse);
    });
    return popularityFavouriteEventResponses;
  }
}
