package com.isa.zajavieni.service;

import com.isa.zajavieni.jsonclasses.Event;
import com.isa.zajavieni.repository.EventList;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EventFilterTest {

    @Test
    void filterEventsList_testIfTheListWillBeTheRightSizeWhenIsOneOrganizer() throws IOException, ParseException {
        EventFilter eventFilter = new EventFilter();
        List<Event> eventList = new DataParseService().parseEvents("events.json");
        List<String> organizersName = new ArrayList<>();
        organizersName.add("Miasto puck");
        String upDate = "2019-08-24";
        Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(upDate);
        String toDate = "2019-08-25";
        Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);

        List<Event> list = eventFilter.filterEventsList(eventList, startDate, endDate, organizersName);

        assertThat(list).hasSize(2);
    }

  @Test
  void filterEventsList_testIfTheListWillBeTheRightSizeWhenAreTwoOrganizers() throws IOException, ParseException {
    EventFilter eventFilter = new EventFilter();
    List<Event> eventList = new DataParseService().parseEvents("events.json");
    List<String> organizersName = new ArrayList<>();
    organizersName.add("Miasto puck");
    organizersName.add("miastomalbork");
    String upDate = "2019-08-24";
    Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(upDate);
    String toDate = "2019-08-25";
    Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);

    List<Event> list = eventFilter.filterEventsList(eventList, startDate, endDate, organizersName);

    assertThat(list).hasSize(3);
  }
}