package com.isa.zajavieni.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.isa.zajavieni.jsonclasses.Event;
import java.io.IOException;
import java.util.List;

import com.isa.zajavieni.repository.EventList;
import org.junit.jupiter.api.Test;

class EventSearchTest {
  @Test
  void searchInListByEventName_testIfTheListWillBeTheRightSize() throws IOException {
    EventSearch eventSearch = new EventSearch();
    List<Event> eventList = new DataParseService().parseEvents(EventList.getEventsJson());

    List<Event> list = eventSearch.searchInListByEventName(eventList, "piosenki");

    assertThat(list).hasSize(3);
  }

  @Test
  void searchInListByOrganizerName_testIfTheListWillBeTheRightSize() throws IOException {
    EventSearch eventSearch = new EventSearch();
    List<Event> eventList = new DataParseService().parseEvents(EventList.getEventsJson());

    List<Event> list = eventSearch.searchInListByOrganizerName(eventList, "miasto malbork");

    assertThat(list).hasSize(4);
  }

  @Test
  void searchInListByOrganizerName_testIfTheListWillBeEmpty() throws IOException {
    EventSearch eventSearch = new EventSearch();
    List<Event> eventList = new DataParseService().parseEvents(EventList.getEventsJson());

    List<Event> list = eventSearch.searchInListByOrganizerName(eventList, "asdasdasd");

    assertThat(list).hasSize(0);
  }
  @Test
  void searchInListByEventName_testIfTheListWillBeEmpty() throws IOException {
    EventSearch eventSearch = new EventSearch();
    List<Event> eventList = new DataParseService().parseEvents(EventList.getEventsJson());

    List<Event> list = eventSearch.searchInListByEventName(eventList, "saasdasdas");

    assertThat(list).hasSize(0);
  }
}