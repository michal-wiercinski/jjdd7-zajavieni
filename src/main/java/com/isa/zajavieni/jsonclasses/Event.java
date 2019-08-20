package com.isa.zajavieni.jsonclasses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;


public class Event {
    @JsonProperty("id")
    private Long eventId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("descShort")
    private String descShort;

    @JsonProperty("descLong")
    private String descLong;

    @JsonProperty("active")
    private Boolean active;

    @JsonProperty("startDate")
    private Date startDate;

    @JsonProperty("endDate")
    private Date endDate;

    @JsonProperty("place")
    private Place place;

    @JsonProperty("organizer")
    private Organizer organizer;

    @JsonProperty("urls")
    private MediaLink hyperlink;

    @JsonProperty("tickets")
    private TicketType ticketType;

    @JsonProperty("categoryId")
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
