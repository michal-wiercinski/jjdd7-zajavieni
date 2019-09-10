package com.isa.zajavieni.mapper;

import com.isa.zajavieni.Entity.Organizer;
import javax.ejb.Stateless;

@Stateless
public class OrganizersMapper {

  public Organizer mapOrganizersApiToEntity(com.isa.zajavieni.jsonclasses.Organizer organizerApi) {

      Organizer organizer = new Organizer();
      organizer.setDesignation(organizerApi.getDesignation());
      organizer.setId(organizerApi.getId());

    return organizer;
  }
}
