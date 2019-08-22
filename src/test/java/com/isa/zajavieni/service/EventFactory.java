package com.isa.zajavieni.service;

import com.isa.zajavieni.jsonclasses.Event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class EventFactory {
    public static Event anEvent(Long id, Date date, String organizerName) {
        Event event = new Event();
        return event;
    }

    public static Event prepareEventToSearch(Long id, String name, String organizerName){
        Event event = new Event();
        event.setEventId(id);
        event.setName(name);
        event.getOrganizer().setDesignation(organizerName);

        return event;
    }

   // public static Event eventToSearchByName()
}
