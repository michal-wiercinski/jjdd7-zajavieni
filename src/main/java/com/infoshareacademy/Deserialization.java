package com.infoshareacademy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Deserialization {
    ObjectMapper objectMapper = new ObjectMapper();

    public List<Category> categoriesDeserialize(String categoriesPathName) throws IOException {
        return objectMapper.readValue(new File(categoriesPathName), new TypeReference<List<Category>>() {
        });
    }

    public List<Place> placesDeserialize(String placePathName) throws IOException {
        return objectMapper.readValue(new File(placePathName), new TypeReference<List<Place>>() {
        });
    }

    public List<Organizer> organizersDeserialize(String placePathName) throws IOException {
        return objectMapper.readValue(new File(placePathName), new TypeReference<List<Organizer>>() {
        });
    }

    public List<Event> eventsDeserialize(String placePathName) throws IOException {
        return objectMapper.readValue(new File(placePathName), new TypeReference<List<Event>>() {
        });
    }
}