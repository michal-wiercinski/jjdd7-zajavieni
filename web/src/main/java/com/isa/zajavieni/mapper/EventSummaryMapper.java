package com.isa.zajavieni.mapper;

import com.isa.zajavieni.dto.EventSummary;
import com.isa.zajavieni.entity.Attachment;
import com.isa.zajavieni.entity.Event;

import java.util.List;

public class EventSummaryMapper {

    public EventSummary mapEventToDto(Event event){
        EventSummary eventSummary = new EventSummary();
        eventSummary.setName(event.getName());
        eventSummary.setStartDate(event.getStartDate());
        eventSummary.setEndDate(event.getEndDate());
        eventSummary.setAddressName(event.getAddress().getName());
        eventSummary.setAddressCity(event.getAddress().getCity());
        List<Attachment> attachment = event.getAttachment();
        if (attachment.isEmpty()) {
            eventSummary.setAttachmentFileName("http://placehold.it/500x325");
        } else {
            eventSummary.setAttachmentFileName(attachment.get(0).getFileName());
        }
        return eventSummary;
    }
}
