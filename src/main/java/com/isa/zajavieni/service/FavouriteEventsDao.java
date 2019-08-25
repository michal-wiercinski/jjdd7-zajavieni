package com.isa.zajavieni.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.isa.zajavieni.jsonclasses.Event;
import com.isa.zajavieni.repository.FavouriteEventList;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class FavouriteEventsDao {

  public void removeFavouriteEventById(Event event) throws IOException {
    FavouriteEventList.getFavouriteEventList().remove(event);
    saveFavouriteEventsFile(FavouriteEventList.getFavouriteEventList());
  }

  public void addFavouriteEventById(Event event) throws IOException {
    FavouriteEventList.getFavouriteEventList().add(event);
    saveFavouriteEventsFile(FavouriteEventList.getFavouriteEventList());
  }

  private void saveFavouriteEventsFile(List<Event> events) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    objectMapper.writeValue(new File("favouriteEvents.json"), events);
  }

  public void updateFavouriteEventsAfterRemoveEvent (Long id) throws IOException {
    List<Event> favouriteEvents = FavouriteEventList.getFavouriteEventList();
    Event foundEvent = favouriteEvents.stream()
        .filter(e -> e.getEventId().equals(id))
        .findFirst().orElse(new Event());
    removeFavouriteEventById(foundEvent);
  }

  public void updateFavouriteEventsAfterUpdateEvent (Event event) throws IOException {
    List<Event> favouriteEvents = FavouriteEventList.getFavouriteEventList();
    Event foundEvent = favouriteEvents.stream()
        .filter(e -> e.getEventId().equals(event.getEventId()))
        .findFirst().orElse(new Event());
    if(!foundEvent.equals(new Event())) {
      removeFavouriteEventById(foundEvent);
      addFavouriteEventById(event);
    }
  }
}
