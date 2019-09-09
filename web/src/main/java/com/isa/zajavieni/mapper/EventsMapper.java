package com.isa.zajavieni.mapper;

import com.isa.zajavieni.Entity.Address;
import com.isa.zajavieni.Entity.Attachment;
import com.isa.zajavieni.Entity.Category;
import com.isa.zajavieni.Entity.CategoryType;
import com.isa.zajavieni.Entity.Event;
import com.isa.zajavieni.Entity.MediaLink;
import com.isa.zajavieni.Entity.Organizer;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class EventsMapper {

  public List<Event> mapEventsApiToEntity(List<com.isa.zajavieni.jsonclasses.Event> eventsApiList) {
    List<Event> events = new ArrayList<>();

    eventsApiList.forEach(eventsApi -> {
      Event event = new Event();
      event.setId(eventsApi.getEventId());
      event.setName(eventsApi.getName());
      event.setDescShort(eventsApi.getDescShort());
      event.setDescLong(eventsApi.getDescLong());
      event.setActive(eventsApi.getActive());
      event.setStartDate(eventsApi.getStartDate());
      event.setEndDate(eventsApi.getEndDate());
      event.setType(eventsApi.getTicketType());

      List<Attachment> attachments = new ArrayList<>();
      eventsApi.getAttachmentList().forEach(
        attachmentApi -> {
          Attachment attachment = new Attachment();
          attachment.setFileName(attachmentApi.getFileName());
          attachments.add(attachment);
        }
      );
      event.setAttachment(attachments);

      MediaLink mediaLink = new MediaLink();
      mediaLink.setFbSite(eventsApi.getMediaLink().getFbSite());
      mediaLink.setWwwAddress(eventsApi.getMediaLink().getWwwAddress());
      mediaLink.setWebsiteWithTickets(eventsApi.getMediaLink().getWebsiteWithTickets());
      event.setMediaLink(mediaLink);

      Address address = new Address();
      address.setId(eventsApi.getPlace().getPlaceId());
      address.setName(eventsApi.getPlace().getName());
      address.setStreet(eventsApi.getPlace().getAddress().getStreet());
      address.setZipcode(eventsApi.getPlace().getAddress().getZipcode());
      address.setCity(eventsApi.getPlace().getAddress().getCity());
      event.setAddress(address);

      Organizer organizer =  new Organizer();
      organizer.setId(eventsApi.getOrganizer().getId());
      organizer.setDesignation(eventsApi.getOrganizer().getDesignation());
      event.setOrganizer(organizer);

      //CategoryType categoryType = new CategoryType();
     // categoryType.setId(categoryApi.getType().getId());
      //categoryType.setName(categoryApi.getType().getName());


      //Category category = new Category();
      //category.setId(eventsApi.getEventId());
      //category.setName(categoryApi.getName());
      //category.setCategoryType(categoryType);
      //event.setCategory(category);

      events.add(event);
    });
    return events;
  }
}
