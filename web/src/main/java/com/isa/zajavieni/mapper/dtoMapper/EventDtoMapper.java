package com.isa.zajavieni.mapper.dtoMapper;

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

  @EJB
  BookingDtoMapper bookingDtoMapper;

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
    if (event.getDescShort() != null) {
      eventDto.setDescShort(event.getDescShort());
    }

    if (event.getDescLong() != null) {
      eventDto.setDescLong(Jsoup.parse(event.getDescLong()).text());
    }
    eventDto
        .setWwwAddress(mediaLinkDtoMapper.mapMediaLinkToDto(event.getMediaLink()).getWwwAddress());
    eventDto.setFbSite(mediaLinkDtoMapper.mapMediaLinkToDto(event.getMediaLink()).getFbSite());
    eventDto.setWebsiteWithTickets(mediaLinkDtoMapper.mapMediaLinkToDto(event.getMediaLink())
        .getWebSiteWithTickets());
    eventDto.setOrganizerName(organizerDtoMapper.mapOrganizerToDto(event.getOrganizer()).getName());
    event.getAttachment().forEach(a -> eventDto.getAttachments()
        .add(attachmentDtoMapper.mapAttachmentToDto(a)));
    event.getBookings().forEach(b -> eventDto.getBookings()
        .add(bookingDtoMapper.mapEntityToDto(b)));
    eventDto.setTicketPool(event.getTicketPool());
    logger.info("Map event entity id: {} to dto", event.getId());
    return eventDto;
  }

  @Transactional
  public Event mapDtoToEntity(EventDto eventDto) {
    Event event = new Event();

    event.setId(eventDto.getId());
   /* event.setName(eventDto.getName());
    event.setStartDate(eventDto.getStartDate());
    event.setEndDate((eventDto.getEndDate()));
    event.getAddress().setCity(eventDto.getAddressCity());
    event.getAddress().setName(eventDto.getAddressName());
    event.getAddress().setStreet(eventDto.getAddressStreet());
    event.getAddress().setZipcode(eventDto.getAddressZipCode());
    event.setDescShort(eventDto.getDescShort());
    event.setDescLong(eventDto.getDescLong());
    event.getMediaLink().setFbSite(eventDto.getFbSite());
    event.getMediaLink().setWebsiteWithTickets(eventDto.getWebsiteWithTickets());
    event.getMediaLink().setWwwAddress(eventDto.getWwwAddress());*/
    eventDto.getBookings().forEach(b -> event.getBookings()
        .add(bookingDtoMapper.mapDtoToEntity(b)));
    event.setTicketPool(eventDto.getTicketPool());

    return event;
  }


}