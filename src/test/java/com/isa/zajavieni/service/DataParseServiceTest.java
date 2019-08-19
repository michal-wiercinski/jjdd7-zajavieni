package com.isa.zajavieni.service;

import com.isa.zajavieni.jsonclasses.Category;
import com.isa.zajavieni.jsonclasses.Event;
import com.isa.zajavieni.jsonclasses.Organizer;
import com.isa.zajavieni.jsonclasses.Place;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataParseServiceTest {

  @Test
  void checkingIfTheCategoryListIsNotNull() throws IOException {
    DataParseService parseCategories = new DataParseService();
    List<Category> list = parseCategories.parseCategories("categories.json");
    assertNotNull(list);
  }

  @Test
  void checkingIfTheEventsListIsNotNull() throws IOException {
    DataParseService parseEvents = new DataParseService();
    List<Event> list = parseEvents.parseEvents("events.json");
    assertNotNull(list);
  }

  @Test
  void checkingIfTheOrganizersListIsNotNull() throws IOException {
    DataParseService parseOrganizers = new DataParseService();
    List<Organizer> list = parseOrganizers.parseOrganizers("organizers.json");
    assertNotNull(list);
  }

  @Test
  void checkingIfThePlacesListIsNotNull() throws IOException {
    DataParseService parsePlaces = new DataParseService();
    List<Place> list = parsePlaces.parsePlaces("places.json");
    assertNotNull(list);
  }

  @Test
  void checkingIfTheObjectIsInTheCategoryList() throws IOException {
    DataParseService parseCategories = new DataParseService();
    List<Category> list = parseCategories.parseCategories("categories.json");
    assertEquals("animowany", list.get(2).getName());
  }

  @Test
  void checkingIfTheObjectIsInTheEventList() throws IOException {
    DataParseService parseEvents = new DataParseService();
    List<Event> list = parseEvents.parseEvents("events.json");
    assertEquals("PRZYSTANEK  PLANSZÓWKI", list.get(49).getName());
  }

  @Test
  void checkingIfTheObjectIsInTheOrganizersList() throws IOException {
    DataParseService parseOrganizers = new DataParseService();
    List<Organizer> list = parseOrganizers.parseOrganizers("organizers.json");
    assertEquals("Instytut Kultury Miejskiej", list.get(9).getDesignation());
  }

  @Test
  void checkingIfTheObjectIsInThePlacesList() throws IOException {
    DataParseService parsePlaces = new DataParseService();
    List<Place> list = parsePlaces.parsePlaces("places.json");
    assertEquals("Dworcowa 9", list.get(14).getAddress().getStreet());
  }

  @Test
  void checkingIfTheObjectsAreNotTheSameInTheCategoryList() throws IOException {
    DataParseService parseCategories = new DataParseService();
    List<Category> list = parseCategories.parseCategories("categories.json");
    assertNotSame(list.get(3), list.get(20));
  }

  @Test
  void checkingIfTheObjectsAreNotTheSameInTheEventList() throws IOException {
    DataParseService parseEvents = new DataParseService();
    List<Event> list = parseEvents.parseEvents("events.json");
    assertNotSame(list.get(30), list.get(61));
  }

  @Test
  void checkingIfTheObjectsAreNotTheSameInTheOrganizersList() throws IOException {
    DataParseService parseOrganizers = new DataParseService();
    List<Organizer> list = parseOrganizers.parseOrganizers("organizers.json");
    assertNotSame(list.get(11), list.get(12));
  }

  @Test
  void checkingIfTheObjectsAreNotTheSameInThePlacesList() throws IOException {
    DataParseService parsePlaces = new DataParseService();
    List<Place> list = parsePlaces.parsePlaces("places.json");
    assertNotSame(list.get(10), list.get(22));
  }
}