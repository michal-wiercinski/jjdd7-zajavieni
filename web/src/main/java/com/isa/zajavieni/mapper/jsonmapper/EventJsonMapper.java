package com.isa.zajavieni.mapper.jsonmapper;

import com.isa.zajavieni.dto.EventDto;
import com.isa.zajavieni.jsonresponse.EventResponse;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

@Stateless
public class EventJsonMapper {

  @Transactional
  public EventResponse mapDtoToJson(EventDto event) {
    EventResponse eventJson = new EventResponse();

    eventJson.setId(event.getId());
    eventJson.setName(event.getName());
    eventJson.setAddressName(event.getAddressName());
    eventJson.setAddressCity(event.getAddressCity());
    eventJson.setAddressStreet(event.getAddressStreet());
    eventJson.setAddressZipCode(event.getAddressZipCode());
    eventJson.setDescShort(event.getDescShort());
    eventJson.setDescLong(event.getDescLong());
    eventJson.setStartDate(event.getStartDate().toString());
    eventJson.setEndDate(event.getEndDate().toString());
    eventJson.setFbSite(event.getFbSite());
    eventJson.setWwwAddress(event.getWwwAddress());
    eventJson.setWebsiteWithTickets(event.getWebsiteWithTickets());

    return eventJson;
  }
}