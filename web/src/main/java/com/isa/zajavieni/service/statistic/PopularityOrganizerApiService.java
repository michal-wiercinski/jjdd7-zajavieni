package com.isa.zajavieni.service.statistic;

import com.isa.zajavieni.dao.PopularityOrganizerDaoBean;
import com.isa.zajavieni.entity.PopularityOrganizer;
import com.isa.zajavieni.entity.statisticapi.PopularityOrganizerResponse;
import com.isa.zajavieni.mapper.PopularityOrganizerMapper;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Stateless
public class PopularityOrganizerApiService {
  @Inject
  private PopularityOrganizerMapper popularityOrganizerMapper;

  @Inject
  private PopularityOrganizerDaoBean popularityOrganizerDaoBean;

  @Transactional
  public List<PopularityOrganizerResponse> getPopularityOrganizerJsonObject() {

    List<PopularityOrganizer> popularityOrganizers = popularityOrganizerDaoBean
        .getPopularityOrganizer();

    List<PopularityOrganizerResponse> popularityOrganizerResponses = new ArrayList<>();

    popularityOrganizers.forEach(popularityOrganizer -> {
      PopularityOrganizerResponse popularityOrganizerResponse = popularityOrganizerMapper
          .mapPopularityOrganizerEntityToApi(popularityOrganizer);
      popularityOrganizerResponses.add(popularityOrganizerResponse);
    });

    return popularityOrganizerResponses;
  }

}
