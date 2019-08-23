package com.isa.zajavieni.service;

import com.isa.zajavieni.jsonclasses.Event;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import static com.isa.zajavieni.service.EventFactory.anEvent;


class EventFilterTest {

@Test
  void filterEventsList_testIfPrintCorrectEvent() throws ParseException {
    EventFilter eventFilter  = new EventFilter(); // arrange

    String upDate="2019-07-08";
    Date startDate = new SimpleDateFormat("yyyy-mm-dd").parse(upDate);
    String toDate="2019-12-02";
    Date endDate = new SimpleDateFormat("yyyy-mm-dd").parse(toDate);

    List<String> organizersName = List.of("codementors");

    List<Event> events = new ArrayList<>();
    events.add(anEvent(2L, new Date(2019,6,21), "infoshare"));
    events.add(anEvent(2L, new Date(2019,1,23), "codementors"));
    events.add(anEvent(3L, new Date(2019,8,22), "sda"));
    events.add(anEvent(4L, new Date(2019,8,24), "codementors"));

    List<Event> filterEvents = eventFilter.filterEventsList(events, startDate, endDate, organizersName);


  }


}