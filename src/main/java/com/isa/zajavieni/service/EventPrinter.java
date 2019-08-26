package com.isa.zajavieni.service;

import com.isa.zajavieni.jsonclasses.Event;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.Instant;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Properties;
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
    for (Event event : eventList) {
      Date newFormatedDate = event.getStartDate();
      SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
      String strDate = formatter.format(newFormatedDate);
      Properties prop = new Properties();
      try (InputStream input = new FileInputStream("/home/mwiercinski/jjdd7-zajavieni/src/resources/zajavieni.properties")) {
        prop.load(input);
        String propertiesOrder = prop.getProperty("dateFormat");
      } catch (IOException ex) {
        ex.printStackTrace();
      }

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

                + ANSI_ORANGE + "\n\t\tData startu: " + ANSI_RESET + event.getStartDate() + ANSI_ORANGE
                + "\n\t\tNazwa Organizatora: " + ANSI_RESET + event.getOrganizer().getDesignation() + "\n");

        counter++;
      } else if (event.getStartDate().getTime() - now > 172800000
          && event.getStartDate().getTime() - now <= 604800000) {
        System.out.println(
            ANSI_YELLOW + counter + "." + "\tNazwa wydarzenia: " + ANSI_RESET + event.getName() +
                ANSI_YELLOW + "\n\t\tID wydarzenia: " + ANSI_RESET + event.getEventId() +
                ANSI_YELLOW + "\n\t\tMiejsce: " + ANSI_RESET + event.getPlace().getName() + ANSI_YELLOW
                + "\n\t\tData startu: " + ANSI_RESET + event.getStartDate() + ANSI_YELLOW
                + "\n\t\tNazwa Organizatora: " + ANSI_RESET + event.getOrganizer().getDesignation() + "\n");
        counter++;
      } else {
        System.out
            .println(counter + "." + "\tNazwa wydarzenia: " + event.getName() + "\n\t\tID wydarzenia: " + event.getEventId() + "\n\t\tMiejsce: "
                + event.getPlace().getName() + "\n\t\tData startu: " + event.getStartDate()
                + "\n\t\tNazwa Organizatora: " + event.getOrganizer().getDesignation() + "\n");

        counter++;
      }
    }
  }

}