package com.isa.zajavieni.mapper;

import com.isa.zajavieni.entity.Attachment;
import com.isa.zajavieni.entity.Event;
import com.isa.zajavieni.dao.AddressDaoBean;
import com.isa.zajavieni.dao.CategoriesDaoBean;
import com.isa.zajavieni.dao.OrganizersDaoBean;
import com.isa.zajavieni.servlet.LoggerServlet;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class EventsMapper {

  private Logger logger = LoggerFactory.getLogger(LoggerServlet.class.getName());

  @Inject
  private AddressDaoBean addressDaoBean;

  @Inject
  private CategoriesDaoBean categoriesDaoBean;

  @Inject
  private OrganizersDaoBean organizersDaoBean;

  @Inject
  private MediaLinkMapper mediaLinkMapper;

  @Inject
  private AttachmentListMapper attachmentListMapper;

  public Event mapEventsApiToEntity(com.isa.zajavieni.jsonclasses.Event eventApi) {
    logger.info("Map eventApi to entity");
    Event event = new Event();
    event.setId(eventApi.getEventId());
    event.setName(eventApi.getName());
    event.setDescShort(eventApi.getDescShort());
    event.setDescLong(eventApi.getDescLong());
    event.setActive(eventApi.getActive());
    event.setStartDate(eventApi.getStartDate());
    event.setEndDate(eventApi.getEndDate());
    event.setType(eventApi.getTicketType());
    List<Attachment> attachments = attachmentListMapper.mapAttachmentApiToEntity(eventApi);
    attachments.forEach(attachment -> attachment.setEvent(event));
    event.setAttachment(attachments);
    event.setMediaLink(mediaLinkMapper.mapMediaLinkApiToEntity(eventApi));
    event.setAddress(addressDaoBean.findAddressById(eventApi.getPlace().getPlaceId()));
    event.setOrganizer(organizersDaoBean.findOrganizerById(eventApi.getOrganizer().getId()));
    event.setCategory(categoriesDaoBean.findCategoryById(eventApi.getCategoryId()));
    return event;
  }
}