package com.isa.zajavieni.service;

import com.isa.zajavieni.jsonclasses.Place;

import java.util.List;

public class PlacePrinter {

    public void printPlaces(List<Place> places) {
        System.out.println("id miejsce");
        for (Place place : places) {
            System.out.println(place.getPlaceId() + " " + place.getName());
        }
    }
}
