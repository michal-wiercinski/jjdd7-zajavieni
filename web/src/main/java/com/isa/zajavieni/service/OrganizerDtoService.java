package com.isa.zajavieni.service;

import com.isa.zajavieni.dao.OrganizersDaoBean;
import com.isa.zajavieni.dto.OrganizerDto;
import com.isa.zajavieni.mapper.OrganizerDtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class OrganizerDtoService {

  @EJB
  OrganizersDaoBean organizersDaoBean;

  @EJB
  OrganizerDtoMapper dtoMapper;

  public List<OrganizerDto> getListByFirstLetter(String letter) {
    return organizersDaoBean.findOrganizersByFirstLetter(letter)
        .stream()
        .map((organizer) -> dtoMapper.mapOrganizerToDto(organizer))
        .collect(Collectors.toList());
  }
}
