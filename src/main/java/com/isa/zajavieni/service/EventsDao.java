package com.isa.zajavieni.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isa.zajavieni.jsonclasses.Event;
import com.isa.zajavieni.repository.EventList;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EventsDao {

    public List<Event> getEvents() throws IOException {
        DataParseService dataParseService = new DataParseService();
        List<Event> events = dataParseService.parseEvents("events2.json");
        return events;
    }

    public Optional<Event> getEventById(Long id) throws IOException {
        for (Event event : getEvents()) {
            if (event.getEventId().equals(id)) {
                return Optional.of(event);
            }
        }
        return Optional.empty();
    }

    public void removeEventById(Long id) throws IOException {
        List<Event> events = EventList.getEventList();
        List<Event> eventsAfterRemove = events.stream()
                .filter(e -> !e.getEventId().equals(id))
                .collect(Collectors.toList());
        EventList.getEventList().clear();
        EventList.getEventList().addAll(eventsAfterRemove);
        saveEventsFile(eventsAfterRemove);
    }

    private void saveEventsFile(List<Event> events) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("events.json"), events);
    }

    public void addEvent(Event event) throws IOException {
        DataParseService dataParseService = new DataParseService();
        List<Event> events = dataParseService.parseEvents("events.json");
        events.add(event);
        saveEventsFile(events);
    }

    public void updateEvent(Event event) {

    }
}
