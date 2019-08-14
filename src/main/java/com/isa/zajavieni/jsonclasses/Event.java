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
    private Links links;

    @JsonProperty("tickets")
    private TicketType ticketType;

    @JsonProperty("categoryId")
    private Long categoryId;

    @JsonProperty("attachments")
    private List<Attachment> attachmentList;

    public Event() {
    }

    public Event(String name, Long eventId) {
        this.name = name;
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Place getPlace() {
        return place;
    }

    public Organizer getOrganizer() {
        return organizer;
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
                ", url=" + links +
                ", ticketType=" + ticketType +
                ", category=" + categoryId +
                ", attachmentList=" + attachmentList +
                '}';
    }
}
