package com.isa.zajavieni.service;

import com.isa.zajavieni.jsonclasses.Category;
import com.isa.zajavieni.jsonclasses.Event;
import com.isa.zajavieni.jsonclasses.Organizer;
import com.isa.zajavieni.jsonclasses.Place;
import com.isa.zajavieni.repository.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataParseServiceTest {

    @Test
    void testIfTheCategoryListIsNotNull() throws IOException {
        DataParseService parseCategories = new DataParseService();

        List<Category> list = parseCategories.parseCategories(CategoryList.getCategoriesJson());

        assertNotNull(list);
    }

    @Test
    void testIfTheEventsListIsNotNull() throws IOException {
        DataParseService parseEvents = new DataParseService();

        List<Event> list = parseEvents.parseEvents(EventList.getEventsJson());

        assertNotNull(list);
    }

    @Test
    void testIfTheOrganizersListIsNotNull() throws IOException {
        DataParseService parseOrganizers = new DataParseService();

        List<Organizer> list = parseOrganizers.parseOrganizers(OrganizerList.getOrganizersJson());

        assertNotNull(list);
    }

    @Test
    void testIfThePlacesListIsNotNull() throws IOException {
        DataParseService parsePlaces = new DataParseService();

        List<Place> list = parsePlaces.parsePlaces(PlaceList.getPlaceJson());

        assertNotNull(list);
    }

    @Test
    void testIfTheObjectIsInTheCategoryList() throws IOException {
        DataParseService parseCategories = new DataParseService();

        List<Category> list = parseCategories.parseCategories(CategoryList.getCategoriesJson());

        assertEquals("animowany", list.get(2).getName());
        assertEquals("komedia", list.get(14).getName());
        assertEquals("balet", list.get(24).getName());
    }

    @Test
    void testIfTheObjectIsInTheOrganizersList() throws IOException {
        DataParseService parseOrganizers = new DataParseService();

        List<Organizer> list = parseOrganizers.parseOrganizers(OrganizerList.getOrganizersJson());

        assertEquals("Instytut Kultury Miejskiej", list.get(9).getDesignation());
        assertEquals("Muzeum Emigracji w Gdyni", list.get(28).getDesignation());
        assertEquals("Klubogaleria Bunkier", list.get(31).getDesignation());
    }

    @Test
    void testIfTheObjectIsInThePlacesList() throws IOException {
        DataParseService parsePlaces = new DataParseService();

        List<Place> list = parsePlaces.parsePlaces(PlaceList.getPlaceJson());

        assertEquals("Dworcowa 9", list.get(14).getAddress().getStreet());
        assertEquals("Turystyczna 3", list.get(12).getAddress().getStreet());
        assertEquals("Akademickie Centrum Kultury UG", list.get(24).getName());
    }

    @Test
    void testIfTheObjectsAreNotTheSameInTheCategoryList() throws IOException {
        DataParseService parseCategories = new DataParseService();

        List<Category> list = parseCategories.parseCategories(CategoryList.getCategoriesJson());

        assertNotSame(list.get(3), list.get(20));
        assertNotSame(list.get(30).getName(), list.get(29).getName());
    }

    @Test
    void testIfTheObjectsAreNotTheSameInTheEventList() throws IOException {
        DataParseService parseEvents = new DataParseService();

        List<Event> list = parseEvents.parseEvents(EventList.getEventsJson());

        assertNotSame(list.get(30), list.get(61));
        assertNotSame(list.get(81).getName(), list.get(82).getName());
        assertNotSame(list.get(2).getEventId(), list.get(90).getName());
    }

    @Test
    void testIfTheObjectsAreNotTheSameInTheOrganizersList() throws IOException {
        DataParseService parseOrganizers = new DataParseService();
        List<Organizer> list = parseOrganizers.parseOrganizers(OrganizerList.getOrganizersJson());

        assertNotSame(list.get(11), list.get(12));
        assertNotSame(list.get(50).getDesignation(), list.get(51).getDesignation());
        assertNotSame(list.get(21).getId(), list.get(20).getId());
    }

    @Test
    void testIfTheObjectsAreNotTheSameInThePlacesList() throws IOException {
        DataParseService parsePlaces = new DataParseService();

        List<Place> list = parsePlaces.parsePlaces(PlaceList.getPlaceJson());

        assertNotSame(list.get(10), list.get(22));
        assertNotSame(list.get(21), list.get(33));
    }

    @Test
    void testIfTheListIsNotNull() throws IOException {
        DataParseService parseService = new DataParseService();
        List<Event> favouriteEvent = parseService.parseFavouriteEvents(FavouriteEventList.getFavouriteEventsJson());
        assertNotNull(favouriteEvent);
    }
}