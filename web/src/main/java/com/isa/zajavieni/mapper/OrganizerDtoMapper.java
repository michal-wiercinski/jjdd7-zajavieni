package com.isa.zajavieni.mapper;

import com.isa.zajavieni.dto.OrganizerDto;
import com.isa.zajavieni.entity.Organizer;

import javax.ejb.Stateless;

@Stateless
public class OrganizerDtoMapper {

    public OrganizerDto mapOrganizerToDto(Organizer organizer){
        OrganizerDto organizerDto = new OrganizerDto();
        organizerDto.setName(organizer.getDesignation());

        return organizerDto;
    }
}
