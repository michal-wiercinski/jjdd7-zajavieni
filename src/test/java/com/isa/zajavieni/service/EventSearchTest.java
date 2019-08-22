package com.isa.zajavieni.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.isa.zajavieni.jsonclasses.Event;
import com.isa.zajavieni.repository.EventList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class EventSearchTest {

  private List<Event> eventList;

  @Test
  void searchInListByEventName_testIfTheListWillBeTheRightSize() throws IOException {
    EventSearch eventSearch = new EventSearch();
    eventList = EventList.getEventList();
    List<Event> list = eventSearch.searchInListByEventName(eventList, "mistrzostwa");

    assertThat(list).hasSize(3);
  }

  @Test
  void searchInListByOrganizerName_testIfTheListWillBeTheRightSize() throws IOException {
    EventSearch eventSearch = new EventSearch();

    eventList = EventList.getEventList();
    List<Event> list = eventSearch.searchInListByOrganizerName(eventList, "Miasto puck");

    assertThat(list).hasSize(8);
  }

  @Test
  void searchInListByEventName_testIfTheListWillBeTheRightSize2() throws IOException {
    EventSearch eventSearch = new EventSearch();

    Event event1 = EventFactory.prepareEventToSearch(1L, "world cup", "FIFA");
    eventList.add(event1);
    Event event2 = EventFactory.prepareEventToSearch(2L, "euro", "UEFA");
    eventList.add(event2);
    Event event3 = EventFactory.prepareEventToSearch(3L, "copa america",
        "CONCACAF");
    eventList.add(event3);
    Event event4 = EventFactory.prepareEventToSearch(4L, "world cup",
        "fifa");
    eventList.add(event4);

    List<Event> list = eventSearch.searchInListByEventName(eventList, "world");

    assertThat(list).hasSize(2);
  }

  @Test
  void searchInListByOrganizerName_testIfTheListWillBeTheRightSize2() throws IOException {
    EventSearch eventSearch = new EventSearch();

    List<Event> eList = new ArrayList<>();
    Event event1 = EventFactory.prepareEventToSearch(1L, "world cup", "FIFA");
    eList.add(event1);
    Event event2 = EventFactory.prepareEventToSearch(2L, "euro", "UEFA");
    eList.add(event2);
    Event event3 = EventFactory.prepareEventToSearch(3L, "copa america",
        "CONCACAF");
    eList.add(event3);
    Event event4 = EventFactory.prepareEventToSearch(4L, "world cup",
        "fifa");
    eList.add(event4);

    List<Event> list = eventSearch.searchInListByEventName(eList, "uefa");

    assertThat(list).hasSize(1);
  }
}