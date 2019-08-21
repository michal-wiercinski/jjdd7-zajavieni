package com.isa.zajavieni.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isa.zajavieni.jsonclasses.Event;
import com.isa.zajavieni.repository.EventList;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class EventsDao {

    public List<Event> getEvents() throws IOException {
        DataParseService dataParseService = new DataParseService();
        List<Event> events = dataParseService.parseEvents("events2.json");
        return events;
    }

    public void removeEventById(Long id) throws IOException {
        List<Event> events = EventList.getEventList();
        List<Event> eventsAfterRemove = events.stream()
                .filter(e -> e.getEventId() != id)
                .collect(Collectors.toList());
        if (eventsAfterRemove.size() == events.size()) {
            System.out.println("Nie znaleziono wydarzenia, lista wydarzeń bez zmian ");
        } else {
            System.out.println("Usunięto wydarzenie");
        }
    }

    private void safeEventsFile(List<Event> events) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("events2.json"), events);
    }

    public void addEvent(Event event) throws IOException {
        DataParseService dataParseService = new DataParseService();
        List<Event> events = dataParseService.parseEvents("events2.json");
        events.add(event);
        safeEventsFile(events);
    }

    public void updateEvent(Event event) {

    }
}
