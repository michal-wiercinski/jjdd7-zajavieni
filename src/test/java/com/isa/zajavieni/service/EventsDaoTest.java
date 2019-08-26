package com.isa.zajavieni.service;

import com.isa.zajavieni.jsonclasses.Event;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

class EventsDaoTest {

    //ten test maj wpływ na plik json
    /* @Test
     void removeEventById_testIfRemoveEvent() throws IOException {
         EventsDao remove = new EventsDao();
         List<Event> eventList = new DataParseService().parseEvents(EventList.getEventsJson());
         Long firstId = eventList.get(0).getEventId();

         Integer expectedListSize = eventList.size() - 1;
         EventList.getEventList().addAll(eventList);

         remove.removeEventById(firstId);


         assertThat(expectedListSize).isEqualTo(EventList.getEventList().size());
     }*/
    @Test
    void getEventById_testIfReturnEventIsNotNull() throws IOException {
        EventsDao eventsDao = new EventsDao();
        Long id = 62425L;

        Optional<Event> expectedEvent = eventsDao.getEventById(id);

        assertNotNull(expectedEvent);
    }

    @Test
    void getEventById_testIfReturnEventIsEmpty() throws IOException {
        EventsDao eventsDao = new EventsDao();
        Long id = 65425L;

        Optional<Event> expectedEvent = eventsDao.getEventById(id);

        assertThat(expectedEvent).isEqualTo(Optional.empty());
    }

    //ten test ma wpływ na plik json
/*    @Test
    void addEvent_testIfListWillHaveGreaterSize() throws IOException {
        EventsDao eventsDao = new EventsDao();
        List<Event> eventList = new DataParseService().parseEvents(EventList.getEventsJson());
        Event event = new Event();

        Integer expectedListSize = eventList.size() + 1;

        eventsDao.addEvent(event);

        assertThat(expectedListSize).isGreaterThan(EventList.getEventList().size());

    }*/
}