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

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescShort() {
        return descShort;
    }

    public void setDescShort(String descShort) {
        this.descShort = descShort;
    }

    public String getDescLong() {
        return descLong;
    }

    public void setDescLong(String descLong) {
        this.descLong = descLong;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public MediaLink getHyperlink() {
        return hyperlink;
    }

    public void setHyperlink(MediaLink hyperlink) {
        this.hyperlink = hyperlink;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public List<Attachment> getAttachmentList() {
        return attachmentList;
    }

    public void setAttachmentList(List<Attachment> attachmentList) {
        this.attachmentList = attachmentList;
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
