package com.isa.zajavieni.mapper.dtomapper;

import com.isa.zajavieni.dto.OrganizerDto;
import com.isa.zajavieni.entity.fromapi.Organizer;
import com.isa.zajavieni.web.servlet.LoggerServlet;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class OrganizerDtoMapper {

  private Logger logger = LoggerFactory.getLogger(LoggerServlet.class.getName());

  public OrganizerDto mapOrganizerToDto(Organizer organizer) {
    OrganizerDto organizerDto = new OrganizerDto();
    organizerDto.setId(organizer.getId());
    organizerDto.setName(organizer.getDesignation());

    logger.info("Map event entity id: {} to dto", organizer.getId());
    return organizerDto;
  }
}
