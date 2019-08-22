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

import static com.isa.zajavieni.service.EventFactory.anEvent;


class EventFilterTest {

  private List<Event> eventList;

  @Test
  void filterEventsList_testIfTheListWillBeTheRightSize() throws ParseException {
    EventFilter eventFilter = new EventFilter(); // arrange

    String upDate = "2019-07-08";
    Date startDate = new SimpleDateFormat("yyyy-mm-dd").parse(upDate);
    String toDate = "2019-12-02";
    Date endDate = new SimpleDateFormat("yyyy-mm-dd").parse(toDate);

    List<String> organizersName = new ArrayList<>();
    organizersName.add("codementors");

    List<Event> events = new ArrayList<>();
    events.add(anEvent(2L, new Date(2019, 6, 21), "infoshare"));
    events.add(anEvent(2L, new Date(2019, 1, 23), "codementors"));
    events.add(anEvent(3L, new Date(2019, 8, 22), "sda"));
    events.add(anEvent(4L, new Date(2019, 8, 24), "codementors"));

    List<Event> filterEvents = eventFilter
        .filterEventsList(events, startDate, endDate, organizersName);

    assertThat(filterEvents).hasSize(1);
  }

  @Test
  void filterEventsList_testIfTheListWillBeTheRightSize1() throws IOException, ParseException {
    EventFilter eventFilter = new EventFilter();
    eventList = EventList.getEventList();

    List<String> organizersName = new ArrayList<>();
    organizersName.add("Miasto Puck");

    String upDate = "2019-07-08";
    Date startDate = new SimpleDateFormat("yyyy-mm-dd").parse(upDate);
    String toDate = "2019-12-02";
    Date endDate = new SimpleDateFormat("yyyy-mm-dd").parse(toDate);

    List<Event> list = eventFilter.filterEventsList(eventList, startDate,endDate,organizersName);

    assertThat(list).hasSize(3);
  }

  @Test
  void searchInListByOrganizerName_testIfTheListWillBeTheRightSize2()
      throws IOException, ParseException {
    EventFilter eventFilter = new EventFilter();
    List<Event> eList = new ArrayList<>();
    String upDate = "2019-07-08";
    Date startDate = new SimpleDateFormat("yyyy-mm-dd").parse(upDate);
    String toDate = "2019-12-02";
    Date endDate = new SimpleDateFormat("yyyy-mm-dd").parse(toDate);
    String date1 = "2019-08-02";
    Date firstEventDate = new SimpleDateFormat("yyyy-mm-dd").parse(date1);
    String date2 = "2019-01-02";
    Date secondEventDate = new SimpleDateFormat("yyyy-mm-dd").parse(date2);
    String date3 = "2017-02-02";
    Date nextEventDate = new SimpleDateFormat("yyyy-mm-dd").parse(date3);

    List<String> organizersName = new ArrayList<>();
    organizersName.add("isa");

    Event event1 = EventFactory.prepareEventToFilter(1L, "ISA", firstEventDate);
    eList.add(event1);
    Event event2 = EventFactory.prepareEventToFilter(2L, "coderslab",secondEventDate);
    eList.add(event2);
    Event event3 = EventFactory.prepareEventToFilter(3L,"sda",nextEventDate);
    eList.add(event3);
    Event event4 = EventFactory.prepareEventToFilter(4L,"codementors", nextEventDate);
    eList.add(event4);

    List<Event> list =
        eventFilter.filterEventsList(eList,startDate,endDate,organizersName);

    assertThat(list).hasSize(1);
  }


}