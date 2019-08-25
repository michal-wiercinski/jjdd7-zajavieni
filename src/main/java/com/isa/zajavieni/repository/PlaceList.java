package com.isa.zajavieni.repository;

import com.isa.zajavieni.jsonclasses.Place;

import java.util.ArrayList;
import java.util.List;

public class PlaceList {

    private static List<Place> placeList = new ArrayList<>();
    private static final String PLACE_JSON = "places.json";

    private PlaceList() {
    }

    public static String getPlaceJson() {
        return PLACE_JSON;
    }

    public static List<Place> getPlaceList() {
        return placeList;
    }
}
