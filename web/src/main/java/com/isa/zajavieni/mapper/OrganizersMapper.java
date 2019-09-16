package com.isa.zajavieni.mapper;

import com.isa.zajavieni.entity.Organizer;
import com.isa.zajavieni.servlet.LoggerServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;

@Stateless
public class OrganizersMapper {

    private Logger logger = LoggerFactory.getLogger(LoggerServlet.class.getName());

    public Organizer mapOrganizersApiToEntity(com.isa.zajavieni.jsonclasses.Organizer organizerApi) {
        logger.info("Map organizersApi id: {} to entity", organizerApi.getId());
        Organizer organizer = new Organizer();
        organizer.setDesignation(organizerApi.getDesignation());
        organizer.setId(organizerApi.getId());
        return organizer;
    }
}
