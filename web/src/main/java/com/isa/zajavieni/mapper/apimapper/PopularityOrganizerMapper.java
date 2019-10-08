package com.isa.zajavieni.mapper.apimapper;

import com.isa.zajavieni.entity.createdentity.PopularityOrganizer;
import com.isa.zajavieni.entity.statisticapi.PopularityOrganizerResponse;
import javax.ejb.Stateless;
import javax.jdo.annotations.Transactional;

@Stateless
public class PopularityOrganizerMapper {

  @Transactional
  public PopularityOrganizerResponse mapPopularityOrganizerEntityToApi(
      PopularityOrganizer popularityOrganizer) {
    PopularityOrganizerResponse popularityOrganizerResponse = new PopularityOrganizerResponse();
    popularityOrganizerResponse
        .setOrganizerName(popularityOrganizer.getOrganizer().getDesignation());
    popularityOrganizerResponse.setQuantity(popularityOrganizer.getQuantity());
    return popularityOrganizerResponse;
  }
}
