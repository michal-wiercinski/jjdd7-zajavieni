package com.isa.zajavieni.service;

import com.isa.zajavieni.jsonclasses.Event;
import com.isa.zajavieni.repository.EventList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

class EventFilterTest {

    @Test
    void filterEventsList_testIfTheListWillBeTheRightSizeWhenIsOneOrganizer() throws IOException, ParseException {
        EventFilter eventFilter = new EventFilter();
        List<Event> eventList = new DataParseService().parseEvents(EventList.getEventsJson());
        List<String> organizersName = new ArrayList<>();
        organizersName.add("instytutkulturymiejskiej");
        String upDate = "2019-09-02";
        Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(upDate);
        String toDate = "2019-09-10";
        Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);

        List<Event> list = eventFilter.filterEventsList(eventList, startDate, endDate, organizersName);

        assertThat(list).hasSize(19);
    }

    @Test
    void filterEventsList_testIfTheListWillBeTheRightSizeWhenAreTwoOrganizers() throws IOException, ParseException {
        EventFilter eventFilter = new EventFilter();
        List<Event> eventList = new DataParseService().parseEvents(EventList.getEventsJson());
        List<String> organizersName = new ArrayList<>();
        organizersName.add("gdańskiarchipelagkultury");
        organizersName.add("sopot");
        String upDate = "2019-09-07";
        Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(upDate);
        String toDate = "2019-09-16";
        Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);

        List<Event> list = eventFilter.filterEventsList(eventList, startDate, endDate, organizersName);

        assertThat(list).hasSize(28);
    }

    @Test
    void filterEventsList_testIfTheListWillBeEmpty() throws IOException, ParseException {
        EventFilter eventFilter = new EventFilter();
        List<Event> eventList = new DataParseService().parseEvents(EventList.getEventsJson());
        List<String> organizersName = new ArrayList<>();
        organizersName.add("gdańskiarchipelagkultury");
        organizersName.add("sopot");

        String upDate = "2017-09-07";
        Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(upDate);
        String toDate = "2018-09-16";
        Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);

        List<Event> list = eventFilter.filterEventsList(eventList, startDate, endDate, organizersName);

        assertTrue(list.isEmpty());
    }
}