package com.isa.zajavieni.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isa.zajavieni.jsonclasses.Category;
import com.isa.zajavieni.jsonclasses.Event;
import com.isa.zajavieni.jsonclasses.Organizer;
import com.isa.zajavieni.jsonclasses.Place;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class DataParseService {
  private ObjectMapper objectMapper = new ObjectMapper();

  public List<Category> parseCategories(String categoriesPathName) throws IOException {
    return objectMapper.readValue(new File(categoriesPathName), new TypeReference<List<Category>>() {
    });
  }

  public List<Place> parsePlaces(String placePathName) throws IOException {
    return objectMapper.readValue(new File(placePathName), new TypeReference<List<Place>>() {
    });
  }

  public List<Organizer> parseOrganizers(String placePathName) throws IOException {
    return objectMapper.readValue(new File(placePathName), new TypeReference<List<Organizer>>() {
    });
  }

  public List<Event> parseEvents(String placePathName) throws IOException {
    return objectMapper.readValue(new File(placePathName), new TypeReference<List<Event>>() {
    });
  }
  public List<Event> parseFavouriteEvents(String placePathName) throws IOException {
    return objectMapper.readValue(new File(placePathName), new TypeReference<List<Event>>() {
    });
  }
}
