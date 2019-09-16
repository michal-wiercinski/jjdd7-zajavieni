package com.isa.zajavieni.mapper;

import com.isa.zajavieni.dto.EventDto;
import com.isa.zajavieni.entity.Address;
import com.isa.zajavieni.entity.Event;

import javax.ejb.EJB;
import javax.transaction.Transactional;
import java.util.Optional;

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

        Optional<String> addressName = Optional.ofNullable(addressDtoMapper.mapAddressToDto(event.getAddress()).getName());
        if (addressName.isPresent()) {
            eventDto.setAddressName(String.valueOf(addressName));
        } else {
            eventDto.setAddressName(noData);
        }

        Optional<String> adddressCity = Optional.ofNullable(addressDtoMapper.mapAddressToDto(event.getAddress()).getCity());
        if (adddressCity.isPresent()) {
            eventDto.setAddressCity(String.valueOf(adddressCity));
        } else {
            eventDto.setAddressCity(noData);
        }

        Optional<String> addressStreet = Optional.ofNullable(addressDtoMapper.mapAddressToDto(event.getAddress()).getStreet());
        if (addressStreet.isPresent()) {
            eventDto.setAddressStreet(String.valueOf(adddressCity));
        } else {
            eventDto.setAddressCity(noData);
        }

        Optional<String> addressZipCode = Optional.ofNullable(addressDtoMapper.mapAddressToDto(event.getAddress()).getZipcode());
        if (addressZipCode.isPresent()) {
            eventDto.setAddressZipCode(String.valueOf(addressZipCode));
        } else {
            eventDto.setAddressZipCode(noData);
        }

        Optional<String> descShort = Optional.ofNullable(event.getDescShort());
        if (descShort.isPresent()) {
            eventDto.setDescShort(String.valueOf(descShort));
        } else {
            eventDto.setDescShort(noData);
        }

        Optional<String> descLong = Optional.ofNullable(event.getDescLong());
        if (descLong.isPresent()) {
            eventDto.setDescLong(String.valueOf(descLong));
        } else {
            eventDto.setDescLong(noData);
        }

        Optional<String> wwwAddress = Optional.ofNullable(mediaLinkDtoMapper.mapMediaLinkToDto(event.getMediaLink()).getWwwAddress());
        if (wwwAddress.isPresent()) {
            eventDto.setWwwAddress(String.valueOf(wwwAddress));
        } else {
            eventDto.setWwwAddress(noData);
        }

        Optional<String> fbSite = Optional.ofNullable(mediaLinkDtoMapper.mapMediaLinkToDto(event.getMediaLink()).getFbSite());
        if (fbSite.isPresent()) {
            eventDto.setFbSite(String.valueOf(fbSite));
        } else {
            eventDto.setFbSite(noData);
        }

        if (mediaLinkDtoMapper.mapMediaLinkToDto(event.getMediaLink()).getWebSiteWithTickets() == null) {
            eventDto.setWebsiteWithTickets(noData);
        } else {
            eventDto.setWebsiteWithTickets(mediaLinkDtoMapper.mapMediaLinkToDto(event.getMediaLink()).getWebSiteWithTickets());
        }

        eventDto.setOrganizerName(organizerDtoMapper.mapOrganizerToDto(event.getOrganizer()).getName());

        Optional<String> fileName = Optional.ofNullable(attachmentDtoMapper.mapAttachmentToDto(event.getAttachment()
                .get(0)).getFileName());
        if (fileName.isPresent() || !fileName.isEmpty()) {
            eventDto.setAttachmentFileName(String.valueOf(fileName));
        } else {
            eventDto.setAttachmentFileName("/img/plug.jpg");
        }
        return eventDto;
    }
}


