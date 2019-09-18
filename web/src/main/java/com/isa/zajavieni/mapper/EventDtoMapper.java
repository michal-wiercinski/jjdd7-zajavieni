package com.isa.zajavieni.mapper;

import com.isa.zajavieni.dto.EventDto;
import com.isa.zajavieni.entity.Event;
import com.isa.zajavieni.servlet.LoggerServlet;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class EventDtoMapper {

  private Logger logger = LoggerFactory.getLogger(LoggerServlet.class.getName());

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
    eventDto.setDescLong(Jsoup.parse(event.getDescLong()).text());
    eventDto
        .setWwwAddress(mediaLinkDtoMapper.mapMediaLinkToDto(event.getMediaLink()).getWwwAddress());
    eventDto.setFbSite(mediaLinkDtoMapper.mapMediaLinkToDto(event.getMediaLink()).getFbSite());
    eventDto.setWebsiteWithTickets(mediaLinkDtoMapper.mapMediaLinkToDto(event.getMediaLink())
        .getWebSiteWithTickets());
    eventDto.setOrganizerName(organizerDtoMapper.mapOrganizerToDto(event.getOrganizer()).getName());
    event.getAttachment()
        .forEach(a -> eventDto.getAttachments().add(attachmentDtoMapper.mapAttachmentToDto(a)));
      eventDto.setFavourite(event.getIsFavourite());
    logger.info("Map event entity id: {} to dto", event.getId());
    return eventDto;
  }
}