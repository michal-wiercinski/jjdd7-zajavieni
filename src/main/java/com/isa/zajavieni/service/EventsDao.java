package com.isa.zajavieni.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isa.zajavieni.jsonclasses.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventsDao {

    public static void main(String[] args) throws IOException {
        EventsDao eventsDao = new EventsDao();
        Event event = new Event();
        event.setEventId(666L);
        event.setName("my event");
        event.setDescShort("opis krótki");
        event.setDescLong("opis długi");
        event.setActive(true);
        event.setStartDate(new Date());
        event.setEndDate(new Date());
        Place place = new Place();
        place.setName("Gdańsk");
        place.setPlaceId(2L);
        event.setPlace(place);
        Organizer organizer = new Organizer();
        organizer.setId(3L);
        organizer.setDesignation("Abc");
        event.setOrganizer(organizer);
        MediaLink hyperlink = new MediaLink("http://wp.pl");
        event.setHyperlink(hyperlink);
        event.setTicketType(TicketType.FREE);
        event.setCategoryId(5L);
        event.setAttachmentList(new ArrayList<>());

        eventsDao.addEvent(event);
        eventsDao.deleteEvent(1L);
    }

    public List<Event> getEvents() throws IOException {
        DataParseService dataParseService = new DataParseService();
        List<Event> events = dataParseService.parseEvents("events2.json");
        return events;
    }

    public void deleteEvent(Long id) throws IOException {
        List<Event> events = getEvents();
        Event event1 = null;
        for (Event event : events) {
            if (event.getEventId().equals(id)) {
                event1 = event;
            }
        }
        if (event1 != null) {
            events.remove(event1);
        }
        safeEventsFile(events);
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
