package com.isa.zajavieni.service;

import com.isa.zajavieni.jsonclasses.Event;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FavouriteEventPrinter {
  private static final String ANSI_RESET = "\u001B[0m";
  private static final String GREEN_BRIGHT = "\033[0;92m";
  public static final String ANSI_RED = "\u001b[38;5;160m";

  public void printFavouriteEvent(List<Event> eventList) throws IOException {
    if(eventList.size()!=0) {
      Optional<Event> result = eventList.stream()
          .min(Comparator.comparing(Event::getStartDate));
      System.out.println(ANSI_RED + "\tTWOJE NAJBLIŻSZE WYDARZENIE:" + ANSI_RESET + GREEN_BRIGHT
          + "\n\tNazwa wydarzenia: " + ANSI_RESET + result.get().getName() + GREEN_BRIGHT +
          "\n\tMiejsce: " + ANSI_RESET + result.get().getPlace().getName() + GREEN_BRIGHT +
          "\n\tData startu: " + ANSI_RESET + result.get().getStartDate() + GREEN_BRIGHT +
          "\n\tNazwa Organizatora: " + ANSI_RESET + result.get().getOrganizer().getDesignation()
          + "\n");
    }
  }

  public void printFavouriteEventConfig(List<Event> eventList, String homeOnly) throws IOException {
    if (homeOnly.equals("true")) {
      printFavouriteEvent(eventList);
    }
  }
/*
  new EventList();
  FavouriteEventPrinter favouriteEventPrinter = new FavouriteEventPrinter();
  favouriteEventPrinter.printFavouriteEvent(EventList.getEventList());

 */

}
