package com.isa.zajavieni.service;

import com.isa.zajavieni.jsonclasses.Place;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class PlacesDao {

    private DataParseService dataParseService = new DataParseService();

    public List<Place> getPlaces() throws IOException {
        return dataParseService.parsePlaces("places.json");
    }

    public Optional<Place> getPlaceById(Long id) throws IOException {
        for (Place place : getPlaces()) {
            if (place.getPlaceId().equals(id)) {
                return Optional.of(place);
            }
        }
        return Optional.empty();
    }

}
