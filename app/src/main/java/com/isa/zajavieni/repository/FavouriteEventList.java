package com.isa.zajavieni.repository;

import com.isa.zajavieni.jsonclasses.Event;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FavouriteEventList {
  private static List<Event> favouriteEventList = new ArrayList<>();
  private static final String FAVOURITE_EVENTS_JSON = "favouriteEvents.json";

  public FavouriteEventList() throws IOException {
  }

  public static String getFavouriteEventsJson() {
    return FAVOURITE_EVENTS_JSON;
  }

  public static List<Event> getFavouriteEventList() {
    return favouriteEventList;
  }

}
