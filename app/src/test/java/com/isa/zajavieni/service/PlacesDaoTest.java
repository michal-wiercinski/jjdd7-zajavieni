package com.isa.zajavieni.service;

import com.isa.zajavieni.jsonclasses.Place;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

class PlacesDaoTest {

    @Test
    void getPlaceById_testIfReturnPlaceIsNotNull() throws IOException {
        PlacesDao placesDao = new PlacesDao();
        Long id = 37L;

        Optional<Place> expectedPlace = placesDao.getPlaceById(id);

        assertNotNull(expectedPlace);
    }

    @Test
    void getPlaceById_testIfReturnPlaceIsEmpty() throws IOException {
        PlacesDao placesDao = new PlacesDao();
        Long id = 4112L;

        Optional<Place> expectedPlace = placesDao.getPlaceById(id);

        assertThat(expectedPlace).isEqualTo(Optional.empty());
    }
}