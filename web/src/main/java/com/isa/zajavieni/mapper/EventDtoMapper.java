package com.isa.zajavieni.mapper;

import com.isa.zajavieni.dto.AttachmentDto;
import com.isa.zajavieni.dto.EventDto;
import com.isa.zajavieni.entity.Attachment;
import com.isa.zajavieni.entity.Event;

import javax.ejb.EJB;
import javax.transaction.Transactional;
import java.util.List;

public class EventDtoMapper {

    @EJB
    AddressDtoMapper addressDtoMapper;

    @EJB
    AttachmentDtoMapper attachmentDtoMapper;

    @EJB
    MediaLinkDtoMapper mediaLinkDtoMapper;

    @EJB
    OrganizerDtoMapper organizerDtoMapper;

    @Transactional
    public EventDto mapEventToDto(Event event) {
        EventDto eventDto = new EventDto();
        eventDto.setId(event.getId());
        eventDto.setName(event.getName());
        eventDto.setStartDate(event.getStartDate());
        eventDto.setEndDate(event.getEndDate());
        eventDto.setAddressName(addressDtoMapper.mapAddressToDto(event.getAddress()).getName());
        eventDto.setAddressCity(addressDtoMapper.mapAddressToDto(event.getAddress()).getCity());
        eventDto.setAddressStreet(addressDtoMapper.mapAddressToDto(event.getAddress()).getStreet());
        eventDto.setAddressZipCode(addressDtoMapper.mapAddressToDto(event.getAddress()).getZipcode());
        eventDto.setDescShort(event.getDescShort());
        eventDto.setDescLong(event.getDescLong());
        eventDto.setWwwAddress(mediaLinkDtoMapper.mapMediaLinkToDto(event.getMediaLink()).getWwwAddress());
        eventDto.setFbSite(mediaLinkDtoMapper.mapMediaLinkToDto(event.getMediaLink()).getFbSite());
        eventDto.setWebsiteWithTickets(mediaLinkDtoMapper.mapMediaLinkToDto(event.getMediaLink()).getWebSiteWithTickets());
        eventDto.setOrganizerName(organizerDtoMapper.mapOrganizerToDto(event.getOrganizer()).getName());
        if (attachmentDtoMapper.mapAttachmentToDto(event.getAttachment()
                .get(0)).getFileName().isEmpty()) {
            eventDto.setAttachmentFileName("/img/plug.jpg");
        } else {
            eventDto.setAttachmentFileName(attachmentDtoMapper.mapAttachmentToDto(event.getAttachment()
                    .get(0)).getFileName());
        }
        return eventDto;
    }
}


