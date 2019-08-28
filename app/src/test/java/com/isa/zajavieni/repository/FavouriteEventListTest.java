package com.isa.zajavieni.repository;

import com.isa.zajavieni.jsonclasses.Event;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FavouriteEventListTest {

    @Test
    void getFavouriteList_testIfListIsNotNull() throws IOException {
        List<Event> list = EventList.getEventList();

        assertNotNull(list);
    }

}