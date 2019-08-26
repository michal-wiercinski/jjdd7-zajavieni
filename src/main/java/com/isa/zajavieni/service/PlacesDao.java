package com.isa.zajavieni.service;

import com.isa.zajavieni.jsonclasses.Place;
import com.isa.zajavieni.repository.PlaceList;

import java.util.Optional;

public class PlacesDao {

    public Optional<Place> getPlaceById(Long id) {
        for (Place place : PlaceList.getPlaceList()) {
            if (place.getPlaceId().equals(id)) {
                return Optional.of(place);
            }
        }
        return Optional.empty();
    }

}
