package com.isa.zajavieni.repository;

import com.isa.zajavieni.jsonclasses.Place;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class PlaceListTest {

    @Test
    void getPlaceList_testIfListIsNotNull() {
        List<Place> list = PlaceList.getPlaceList();

        assertNotNull(list);
    }
}