package com.isa.zajavieni.mapper;

import com.isa.zajavieni.Entity.Attachment;
import com.isa.zajavieni.Entity.Event;
import com.isa.zajavieni.Entity.MediaLink;
import com.isa.zajavieni.dao.AddressDaoBean;
import com.isa.zajavieni.dao.CategoriesDaoBean;
import com.isa.zajavieni.dao.OrganizersDaoBean;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EventsMapper {

  @Inject
  private AddressDaoBean addressDaoBean;

  @Inject
  private CategoriesDaoBean categoriesDaoBean;

  @Inject
  private OrganizersDaoBean organizersDaoBean;

  public Event mapEventsApiToEntity(com.isa.zajavieni.jsonclasses.Event eventApi) {

      Event event = new Event();
      event.setId(eventApi.getEventId());
      event.setName(eventApi.getName());
      event.setDescShort(eventApi.getDescShort());
      event.setDescLong(eventApi.getDescLong());
      event.setActive(eventApi.getActive());
      event.setStartDate(eventApi.getStartDate());
      event.setEndDate(eventApi.getEndDate());
      event.setType(eventApi.getTicketType());

      List<Attachment> attachments = new ArrayList<>();
      eventApi.getAttachmentList().forEach(
        attachmentApi -> {
          Attachment attachment = new Attachment();
          attachment.setFileName(attachmentApi.getFileName());
          attachments.add(attachment);
        }
      );
      event.setAttachment(attachments);

      MediaLink mediaLink = new MediaLink();
      mediaLink.setFbSite(eventApi.getMediaLink().getFbSite());
      mediaLink.setWwwAddress(eventApi.getMediaLink().getWwwAddress());
      mediaLink.setWebsiteWithTickets(eventApi.getMediaLink().getWebsiteWithTickets());
      event.setMediaLink(mediaLink);

      event.setAddress(addressDaoBean.findAddressById(eventApi.getPlace().getPlaceId()));
      event.setOrganizer(organizersDaoBean.findOrganizerById(eventApi.getOrganizer().getId()));
      event.setCategory(categoriesDaoBean.findCategoryById(eventApi.getCategoryId()));

    return event;
  }
}
