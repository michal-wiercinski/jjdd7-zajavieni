package com.infoshareacademy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Deserializer {

    private ObjectMapper objectMapper = new ObjectMapper();

    public List<Category> deserializeCategories(String path) throws IOException {
        return objectMapper.readValue(new File(path), new TypeReference<List<Category>>() {});
    }

    public List<Place> deserializePlaces(String path) throws IOException {
        return objectMapper.readValue(new File(path), new TypeReference<List<Place>>() {});
    }

    public List<Organizer> deserializeOrganizers(String path) throws IOException {
        return objectMapper.readValue(new File(path), new TypeReference<List<Organizer>>() {});
    }

    public List<Event> deserializeEvents(String path) throws IOException {
        return objectMapper.readValue(new File(path), new TypeReference<List<Event>>() {});
    }
}
