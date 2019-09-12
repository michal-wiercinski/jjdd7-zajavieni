package com.isa.zajavieni.mapper;

import com.isa.zajavieni.entity.Organizer;
import com.isa.zajavieni.servlet.LoggerServlet;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class OrganizersMapper {

  private Logger logger = LoggerFactory.getLogger(LoggerServlet.class.getName());

  public Organizer mapOrganizersApiToEntity(com.isa.zajavieni.jsonclasses.Organizer organizerApi) {
    logger.info("Map organizersApi to entity");
    Organizer organizer = new Organizer();
    organizer.setDesignation(organizerApi.getDesignation());
    organizer.setId(organizerApi.getId());
    return organizer;
  }
}