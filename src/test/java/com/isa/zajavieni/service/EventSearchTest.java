package com.isa.zajavieni.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.isa.zajavieni.jsonclasses.Event;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;

class EventSearchTest {
  @Test
  void searchInListByEventName_testIfTheListWillBeTheRightSize() throws IOException {
    EventSearch eventSearch = new EventSearch();
    List<Event> eventList = new DataParseService().parseEvents("events.json");

    List<Event> list = eventSearch.searchInListByEventName(eventList, "mistrzostwa");


    assertThat(list).hasSize(3);
  }

  @Test
  void searchInListByOrganizerName_testIfTheListWillBeTheRightSize() throws IOException {
    EventSearch eventSearch = new EventSearch();
    List<Event> eventList = new DataParseService().parseEvents("events.json");

    List<Event> list = eventSearch.searchInListByOrganizerName(eventList, "Miasto puck");

    assertThat(list).hasSize(8);
  }

  @Test
  void searchInListByOrganizerName_testIfTheListWillBeEmpty() throws IOException {
    EventSearch eventSearch = new EventSearch();
    List<Event> eventList = new DataParseService().parseEvents("events.json");

    List<Event> list = eventSearch.searchInListByOrganizerName(eventList, "asdasdasd");

    assertThat(list).hasSize(0);
  }
  @Test
  void searchInListByEventName_testIfTheListWillBeEmpty() throws IOException {
    EventSearch eventSearch = new EventSearch();
    List<Event> eventList = new DataParseService().parseEvents("events.json");

    List<Event> list = eventSearch.searchInListByEventName(eventList, "saasdasdas");

    assertThat(list).hasSize(0);
  }
}