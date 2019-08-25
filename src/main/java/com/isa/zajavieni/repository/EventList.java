package com.isa.zajavieni.repository;

import com.isa.zajavieni.service.DataParseService;
import com.isa.zajavieni.jsonclasses.Event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EventList {
    private static List<Event> eventList = new ArrayList<>();
    private static final String EVENTS_JSON = "events.json";

    private EventList() throws IOException {
    }

    public static String getEventsJson() {
        return EVENTS_JSON;
    }

    public static List<Event> getEventList() {
        return eventList;
    }
}