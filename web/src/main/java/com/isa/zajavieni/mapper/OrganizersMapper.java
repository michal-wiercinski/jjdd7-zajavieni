package com.isa.zajavieni.mapper;

import com.isa.zajavieni.Entity.Organizer;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class OrganizersMapper {

  public List<Organizer> mapOrganizersApiToEntity(List<com.isa.zajavieni.jsonclasses.Organizer> organizersApiList) {
    List<Organizer> organizers = new ArrayList<>();

    organizersApiList.forEach(organizersApi -> {
      Organizer organizer = new Organizer();
      organizer.setDesignation(organizersApi.getDesignation());
      organizer.setId(organizersApi.getId());
      organizers.add(organizer);
    });
    return organizers;
  }
}
