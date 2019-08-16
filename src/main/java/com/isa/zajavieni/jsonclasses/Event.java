package com.isa.zajavieni.jsonclasses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;


public class Event {
    @JsonProperty("id")
    private Long eventId;

    private String name;

    private String descShort;

    private String descLong;

    private Boolean active;

    private Date startDate;

    private Date endDate;

    private Place place;

    private Organizer organizer;

    @JsonProperty("urls")
    private MediaLink hyperlink;

    @JsonProperty("tickets")
    private TicketType ticketType;

    private Long categoryId;

    @JsonProperty("attachments")
    private List<Attachment> attachmentList;

    public Long getEventId() {
        return eventId;
    }

    public String getName() {
        return name;
    }

    public String getDescShort() {
        return descShort;
    }

    public String getDescLong() {
        return descLong;
    }

    public Boolean getActive() {
        return active;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Place getPlace() {
        return place;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public MediaLink getHyperlink() {
        return hyperlink;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public List<Attachment> getAttachmentList() {
        return attachmentList;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventID=" + eventId +
                ", name='" + name + '\'' +
                ", descShort='" + descShort + '\'' +
                ", descLong='" + descLong + '\'' +
                ", active=" + active +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", place=" + place +
                ", organizer=" + organizer +
                ", url=" + hyperlink +
                ", ticketType=" + ticketType +
                ", category=" + categoryId +
                ", attachmentList=" + attachmentList +
                '}';
    }
}
