package com.isa.zajavieni;

import com.isa.zajavieni.jsonclasses.Event;

import java.time.ZoneId;
import java.util.Date;

public class EventFactory {
    public Event getEvent(String name, Date startDate, String placeName, String city){
        Event event = new Event();
        event.setName(name);
        event.setStartDate(startDate);
        startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        event.getPlace().setName(placeName);
        event.getPlace().getAddress().setCity(city);

        return event;
    }
}
