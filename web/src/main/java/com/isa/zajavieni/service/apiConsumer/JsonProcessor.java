package com.isa.zajavieni.service.apiConsumer;

import com.isa.zajavieni.dao.AddressDaoBean;
import com.isa.zajavieni.dao.EventsDaoBean;
import com.isa.zajavieni.dao.OrganizersDaoBean;
import com.isa.zajavieni.entity.Address;
import com.isa.zajavieni.jsonclasses.Event;
import com.isa.zajavieni.jsonclasses.Organizer;
import com.isa.zajavieni.jsonclasses.Place;
import com.isa.zajavieni.mapper.entityMapper.AddressMapper;
import com.isa.zajavieni.mapper.entityMapper.EventsMapper;
import com.isa.zajavieni.mapper.entityMapper.OrganizersMapper;
import com.isa.zajavieni.parser.DataParseService;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class JsonProcessor {

  @EJB
  private DataParseService dataParseService;

  @EJB
  private EventsMapper eventsMapper;

  @EJB
  private AddressMapper addressMapper;

  @EJB
  private OrganizersMapper organizersMapper;

  @EJB
  private EventsDaoBean eventsDaoBean;

  @EJB
  private AddressDaoBean addressDaoBean;

  @EJB
  private OrganizersDaoBean organizersDaoBean;

  public void processEventsJson(String eventsJson) throws IOException {
    List<Event> events = dataParseService.parseEvents(eventsJson);
    for (Event event : events) {
      com.isa.zajavieni.entity.Event mapEventToEntity = eventsMapper.mapEventsApiToEntity(event);
      eventsDaoBean.saveEvent(mapEventToEntity);
    }
  }

  public void processPlaceFile(String placesJson) throws IOException {
    List<Place> places = dataParseService.parsePlaces(placesJson);
    for (Place place : places) {
      Address address = addressMapper.mapAddressApiToEntity(place);
      addressDaoBean.savePlace(address);
    }
  }

  public void processOrganizerFile(String organizersJson) throws IOException {
    List<Organizer> organizers = dataParseService.parseOrganizers(organizersJson);
    for (Organizer organizer : organizers) {
      com.isa.zajavieni.entity.Organizer mapOrganizerToEntity = organizersMapper
          .mapOrganizersApiToEntity(organizer);
      organizersDaoBean.saveOrganizer(mapOrganizerToEntity);
    }
  }
}