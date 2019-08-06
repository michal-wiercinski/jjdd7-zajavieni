package com.infoshareacademy;

import java.util.Date;
import java.util.List;

public class Event {
    private String name;
    private String descShort;
    private String descLong;
    private Long eventID;
    private Boolean active;
    private Date startDate;
    private Date endDate;
    private Place place;
    private Organizer organizer;
    private Url url;
    private TicketType ticketType;
    private Category categoryID;
    private List<Attachment> attachmentList;

    public Event(String name, Long eventID) {
        this.name = name;
        this.eventID = eventID;
    }
}
