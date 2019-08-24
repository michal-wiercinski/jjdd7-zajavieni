package com.isa.zajavieni.service;

import com.isa.zajavieni.jsonclasses.Event;
import com.isa.zajavieni.repository.EventList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class EventsDaoTest {

    @Test
    void removeEventById_testIfRemoveEvent() throws IOException {


        EventsDao remove = new EventsDao();

        List<Event> eventList = new DataParseService().parseEvents(EventList.getEventsJson());
        Long firstId = eventList.get(0).getEventId();

        Integer expectedListSize = eventList.size()-1;
        EventList.getEventList().addAll(eventList);

        remove.removeEventById(firstId);


        assertThat(expectedListSize).isEqualTo(EventList.getEventList().size());
    }
}