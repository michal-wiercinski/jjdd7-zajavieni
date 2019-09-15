package com.isa.zajavieni.mapper;

import com.isa.zajavieni.dto.EventSummary;
import com.isa.zajavieni.entity.Attachment;
import com.isa.zajavieni.entity.Event;

import java.util.List;

public class EventSummaryMapper {

    public EventSummary mapEventToDto(Event event){
        EventSummary eventSummary = new EventSummary();
        eventSummary.setId(event.getId());
        eventSummary.setName(event.getName());
        eventSummary.setStartDate(event.getStartDate());
        eventSummary.setEndDate(event.getEndDate());
        eventSummary.setAddressName(event.getAddress().getName());
        eventSummary.setAddressCity(event.getAddress().getCity());
        eventSummary.setAddressStreet(event.getAddress().getStreet());
        eventSummary.setAddressZipCode(event.getAddress().getZipcode());
        eventSummary.setDescShort(event.getDescShort());
        eventSummary.setDescLong(event.getDescLong());
        //eventSummary.setTicketType(event.getType().toString());
        eventSummary.setWwwAddress(event.getMediaLink().getWwwAddress());
        eventSummary.setFbSite(event.getMediaLink().getFbSite());
        eventSummary.setWebsiteWithTickets(event.getMediaLink().getWebsiteWithTickets());
        List<Attachment> attachment = event.getAttachment();
        if (attachment.isEmpty()) {
            eventSummary.setAttachmentFileName("/img/plug.jpg");
        } else {
            eventSummary.setAttachmentFileName(attachment.get(0).getFileName());
        }
        return eventSummary;
    }
}