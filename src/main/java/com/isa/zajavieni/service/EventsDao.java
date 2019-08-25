package com.isa.zajavieni.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
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
        List<Event> events = dataParseService.parseEvents("events.json");
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
        saveEventsFile(eventsAfterRemove);
    }

    private void saveEventsFile(List<Event> events) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.writeValue(new File("events.json"), events);
    }

    public void addEvent(Event event) throws IOException {
        DataParseService dataParseService = new DataParseService();
        List<Event> events = dataParseService.parseEvents("events.json");
        events.add(event);
        saveEventsFile(events);
    }

    public void updateEvent(Event event) throws IOException {
        List<Event> events = getEvents();
        for (int i = 0; i < events.size(); i++) {
            if (event.getEventId().equals(events.get(i).getEventId())) {
                events.set(i, event);
                break;
            }
        }
        saveEventsFile(events);
    }

    public Long getNextId() throws IOException {
        List<Event> events = getEvents();
        long maxId = events.stream()
                .mapToLong(event -> event.getEventId())
                .max()
                .orElseGet(() -> 0);
        return maxId + 1;
    }
}
