package com.isa.zajavieni.service;

import com.isa.zajavieni.jsonclasses.Event;

import java.io.IOException;
import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EventPrinter {

  private static final String ANSI_RESET = "\u001B[0m";
  private static final String ANSI_YELLOW = "\u001b[33;1m";
  public static final String ANSI_ORANGE = "\u001b[38;5;208m";

  public void printListOfEvents(List<Event> eventList) throws IOException {
    List<Event> eventsList = eventList.stream()
        .sorted(Comparator.comparing(Event::getStartDate))
        .collect(Collectors.toList());
    long now = Instant.now().toEpochMilli();
    int counter = 1;
    for (Event event : eventsList) {
      if (event.getStartDate().getTime() - now <= 172800000) {
        System.out.println(
            ANSI_ORANGE + counter + "." + "\tNazwa wydarzenia: " + ANSI_RESET + event.getName() +
                ANSI_ORANGE + "\n\tMiejsce: " + ANSI_RESET + event.getPlace().getName()
                + ANSI_ORANGE + "\n\tData startu: " + ANSI_RESET + event.getStartDate() + ANSI_ORANGE
                + "\n\tNazwa Organizatora: " + ANSI_RESET + event.getOrganizer().getDesignation() + "\n");
        counter++;
      } else if (event.getStartDate().getTime() - now > 172800000
          && event.getStartDate().getTime() - now <= 604800000) {
        System.out.println(
            ANSI_YELLOW + counter + "." + "\tNazwa wydarzenia: " + ANSI_RESET + event.getName() +
                ANSI_YELLOW + "\n\tMiejsce: " + ANSI_RESET + event.getPlace().getName() + ANSI_YELLOW
                + "\n\tData startu: " + ANSI_RESET + event.getStartDate() + ANSI_YELLOW
                + "\n\tNazwa Organizatora: " + ANSI_RESET + event.getOrganizer().getDesignation() + "\n");
        counter++;
      } else {
        System.out
            .println(counter + "." + "\tNazwa wydarzenia: " + event.getName() + "\n\tMiejsce: "
                + event.getPlace().getName() + "\n\tData startu: " + event.getStartDate()
                + "\n\tNazwa Organizatora: " + event.getOrganizer().getDesignation() + "\n");
        counter++;
      }
    }
  }

  public void printListOfEventsInFavourite(List<Event> eventList) throws IOException {
    List<Event> eventsList = eventList.stream()
        .sorted(Comparator.comparing(Event::getStartDate))
        .collect(Collectors.toList());
    long now = Instant.now().toEpochMilli();
    int counter = 1;
    for (Event event : eventsList) {
      if (event.getStartDate().getTime() - now <= 172800000) {
        System.out.println(
            ANSI_ORANGE + counter + "." + "\tNazwa wydarzenia: " + ANSI_RESET + event.getName() +
                ANSI_ORANGE + "\n\t\tID wydarzenia: " + ANSI_RESET + event.getEventId() +
                ANSI_ORANGE + "\n\t\tMiejsce: " + ANSI_RESET + event.getPlace().getName()
                + ANSI_ORANGE + "\n\t\tData startu: " + ANSI_RESET + event.getStartDate() + "\n");
        counter++;
      } else if (event.getStartDate().getTime() - now > 172800000
          && event.getStartDate().getTime() - now <= 604800000) {
        System.out.println(
            ANSI_YELLOW + counter + "." + "\tNazwa wydarzenia: " + ANSI_RESET + event.getName() +
                ANSI_YELLOW + "\n\t\tID wydarzenia: " + ANSI_RESET + event.getEventId() +
                ANSI_YELLOW + "\n\t\tMiejsce: " + ANSI_RESET + event.getPlace().getName() + ANSI_YELLOW
                + "\n\t\tData startu: " + ANSI_RESET + event.getStartDate() + "\n");
        counter++;
      } else {
        System.out
            .println(counter + "." + "\tNazwa wydarzenia: " + event.getName() + "\n\t\tID wydarzenia: "
                + event.getEventId() +"\n\t\tMiejsce: " + event.getPlace().getName()
                + "\n\t\tData startu: " + event.getStartDate() + "\n");
        counter++;
      }
    }
  }

}