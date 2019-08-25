package com.isa.zajavieni.menu;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.isa.zajavieni.jsonclasses.Event;
import com.isa.zajavieni.repository.EventList;
import com.isa.zajavieni.repository.FavouriteEventList;
import com.isa.zajavieni.service.EventPrinter;
import com.isa.zajavieni.service.FavouriteEventsDao;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class FavouriteEventMenu {

  FavouriteEventsDao favouriteEventsDao = new FavouriteEventsDao();

  public void printFavouriteMenu() throws IOException, ParseException {
    printTextFavouriteMenu();
    Scanner scanner = new Scanner(System.in);
    String choice = scanner.nextLine();
    printFavouriteMenu(choice);
  }

  private void printTextFavouriteMenu() {
    System.out.println("\tCo chcesz zrobić?");
    System.out.println("\t1. Wyświetl ulubione wydarzenia");
    System.out.println("\t2. Dodaj wydarzenie do ulubionych");
    System.out.println("\t3. Wykasuj wydarzenie z ulubionych");
    System.out.println("\t4. Wróć do głównego menu");
  }

  private void printFavouriteMenu(String choice) throws IOException, ParseException {
    EventPrinter eventPrinter = new EventPrinter();
    switch (choice) {
      case "1":
        new EventPrinter().printListOfEvents(FavouriteEventList.getFavouriteEventList());
        if (FavouriteEventList.getFavouriteEventList().size() == 0) {
          System.out.println("Brak wydarzeń na liście ulubionbych");
        }
        backToSearch();
        break;
      case "2":
        eventPrinter.printListOfEventsInFavourite(EventList.getEventList());
        Event eventToAdd = prepareToAddingFavouriteEvent();
        favouriteEventsDao.addFavouriteEventById(eventToAdd);
        backToSearch();
        break;
      case "3":
        eventPrinter.printListOfEventsInFavourite(FavouriteEventList.getFavouriteEventList());
        if (FavouriteEventList.getFavouriteEventList().size() == 0) {
          System.out.println("Brak wydarzeń na liście ulubionbych");
        } else {
          Event eventToRemove = prepareToRemovingFavouriteEvent();
          favouriteEventsDao.removeFavouriteEventById(eventToRemove);
        }
        backToSearch();
        break;
      case "4":
        new MainMenu().mainMenu();
        break;
      default:
        System.out.println("Prosze podac cyfre z zakresu submenu");
        printFavouriteMenu();
    }
  }


  private Event prepareToAddingFavouriteEvent() throws IOException, ParseException {
    System.out.println("Wpisz ID wydarzenia które chcesz dodać do ulubionych:");
    Scanner scanner = new Scanner(System.in);
    Long idOfEvent = null;
    do {
      String idOfEventString = scanner.nextLine();
      try {
        idOfEvent = Long.parseLong(idOfEventString);
      } catch (NumberFormatException nfe) {

      } finally {
        if (idOfEvent == null) {
          System.out.println("Format ID niepoprawny. Podaj poprawny numer ID:");
        }
      }
    } while (idOfEvent == null);

    EventList eventList = new EventList();
    List<Event> events = eventList.getEventList();
    Event favouriteEventToAdd = null;
    if (FavouriteEventList.getFavouriteEventList().size() < 3) {
      boolean correctAdded = false;
      for (Event event : events) {
        if (idOfEvent.equals(event.getEventId())) {
          favouriteEventToAdd = event;
          System.out.println("Poprawnie dodano wydarzenie do ulubionych");
          correctAdded = true;
          break;
        }
      }
      if (correctAdded == false) {
        System.out.println("Wpisano ID nieprzypisane do żadnego wydarzenia.");
        backToSearch();
      }
    } else {
      System.out
          .println("Nie można dodać wydarzenia do listy ulubionych (Maksymalna liczba wydarzeń "
              + "w liście ulubionych wynosi 3");
      backToSearch();
    }
    return favouriteEventToAdd;
  }

  private Event prepareToRemovingFavouriteEvent() throws IOException, ParseException {
    System.out.println("Wpisz ID wydarzenia które chcesz usunąć z ulubionych:");
    Scanner scanner = new Scanner(System.in);
    Long idOfEvent = null;
    do {
      String idOfEventString = scanner.nextLine();
      try {
        idOfEvent = Long.parseLong(idOfEventString);
      } catch (NumberFormatException nfe) {

      } finally {
        if (idOfEvent == null) {
          System.out.println("Format ID niepoprawny. Podaj poprawny numer ID:");
        }
      }
    } while (idOfEvent == null);
    boolean correctRemove = false;
    Event favouriteEventToRemove = null;
    for (Event event : FavouriteEventList.getFavouriteEventList()) {
      if (idOfEvent.equals(event.getEventId())) {
        favouriteEventToRemove = event;
        System.out.println("Poprawnie usunięto wydarzenie z ulubionych");
        correctRemove = true;
        break;
      } else {
        System.out.println("Wpisano ID nieprzypisane do żadnego wydarzenia. Wpisz ponownie ID");
        prepareToRemovingFavouriteEvent();
      }
    }
    if (correctRemove == false) {
      System.out.println("Wpisano ID nieprzypisane do żadnego wydarzenia.");
      backToSearch();
    }
    return favouriteEventToRemove;
  }

  private void backToSearch() throws IOException, ParseException {
    System.out.println("Czy chcesz kontynuować zarzadzanie ulubionymi? t / n");
    Scanner scanner = new Scanner(System.in);
    String yesOrNot = scanner.nextLine();
    if (yesOrNot.equalsIgnoreCase("n")) {
      new MainMenu().mainMenu();
    } else if (yesOrNot.equalsIgnoreCase("t")) {
      printFavouriteMenu();
    } else {
      System.out.println("Wpisałeś coś niewłaściwego. Wybierz t lub n.");
      backToSearch();
    }
  }

}
