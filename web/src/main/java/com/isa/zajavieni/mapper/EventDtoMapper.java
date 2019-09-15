package com.isa.zajavieni.mapper;

import com.isa.zajavieni.dto.EventDto;
import com.isa.zajavieni.entity.Address;
import com.isa.zajavieni.entity.Event;

import javax.ejb.EJB;
import javax.transaction.Transactional;

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
        String noData = "brak danych";
        EventDto eventDto = new EventDto();
        eventDto.setId(event.getId());
        eventDto.setName(event.getName());
        eventDto.setStartDate(event.getStartDate());
        eventDto.setEndDate(event.getEndDate());

        if (addressDtoMapper.mapAddressToDto(event.getAddress()).getName() == null) {
            eventDto.setAddressName(noData);
        } else {
            eventDto.setAddressName(addressDtoMapper.mapAddressToDto(event.getAddress()).getName());
        }

        if (addressDtoMapper.mapAddressToDto(event.getAddress()).getCity() == null) {
            eventDto.setAddressCity(noData);
        } else {
            eventDto.setAddressCity(addressDtoMapper.mapAddressToDto(event.getAddress()).getCity());
        }

        if (addressDtoMapper.mapAddressToDto(event.getAddress()).getStreet() == null) {
            eventDto.setAddressStreet(noData);
        } else {
            eventDto.setAddressCity(addressDtoMapper.mapAddressToDto(event.getAddress()).getStreet());
        }

        if (addressDtoMapper.mapAddressToDto(event.getAddress()).getZipcode() == null) {
            eventDto.setAddressZipCode(noData);
        } else {
            eventDto.setAddressZipCode(addressDtoMapper.mapAddressToDto(event.getAddress()).getZipcode());
        }

        if (event.getDescShort()== null) {
            eventDto.setDescShort(noData);
        } else {
            eventDto.setDescShort(event.getDescShort());
        }

        if (event.getDescLong() == null) {
            eventDto.setDescLong(noData);
        } else {
            eventDto.setDescLong(event.getDescLong());
        }

        if (mediaLinkDtoMapper.mapMediaLinkToDto(event.getMediaLink()).getWwwAddress() == null) {
            eventDto.setWwwAddress(noData);
        } else {
            eventDto.setWwwAddress(mediaLinkDtoMapper.mapMediaLinkToDto(event.getMediaLink()).getWwwAddress());
        }

        if (mediaLinkDtoMapper.mapMediaLinkToDto(event.getMediaLink()).getFbSite() == null) {
            eventDto.setFbSite(noData);
        } else {
            eventDto.setFbSite(mediaLinkDtoMapper.mapMediaLinkToDto(event.getMediaLink()).getFbSite());
        }

        if (mediaLinkDtoMapper.mapMediaLinkToDto(event.getMediaLink()).getWebSiteWithTickets()== null) {
            eventDto.setWebsiteWithTickets(noData);
        }else {
            eventDto.setWebsiteWithTickets(mediaLinkDtoMapper.mapMediaLinkToDto(event.getMediaLink()).getWebSiteWithTickets());
        }

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


