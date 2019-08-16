package com.isa.zajavieni.service;

import com.isa.zajavieni.jsonclasses.Event;
import com.isa.zajavieni.jsonclasses.Organizer;
import com.isa.zajavieni.repository.EventList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchEvent {
    public List<Event> listFound = new ArrayList<>();

    public void printSelectionMenu() throws IOException {
        System.out.println("Po czym chcesz wyszukać wydarzenie?");
        System.out.println("1. Nazwa wydarzenia");
        System.out.println("2. Nazwa organizatora");
        System.out.println("3. Filtruj po dacie");
        Scanner scanner = new Scanner(System.in);
        String whatYouWant = scanner.nextLine();
        printMenu(whatYouWant);
    }

    private void printMenu(String whatYouWant) throws IOException {
        PrinterEvents eventService = new PrinterEvents();
        EventList eventList = new EventList();
        switch (whatYouWant) {
            case "1":
                eventService.printListOfEvents(searchInListByEventName(EventList.getEventList()));
                break;
            case "2":
                eventService.printListOfEvents(searchInListByOrganizerName(EventList.getEventList()));
                break;
            case "3":
                System.out.println("3. To będzie działać filtrowanie daty");
                break;
            default:
                System.out.println("Prosze podac cyfre z zakresu submenu");
        }
    }

    private String typeWhatYouNeed() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Co Cię interesuje?");
        String name = scanner.nextLine();
        if (name.length() < 3) {
            System.out.println("Podałeś za mało liter, spróbuj ponownie");
            typeWhatYouNeed();
        }
        return name;
    }

    private List<Event> searchInListByEventName(List<Event> eventsList) throws IOException {
        String eventName = typeWhatYouNeed();
        listFound = eventsList.stream()
                .filter(e -> e.getName().toUpperCase().contains(eventName.toUpperCase()))
                .collect(Collectors.toList());
        if (listFound.isEmpty()) {
            System.out.println("Nie znaleziono żadnych wyników");
            searchInListByEventName(eventsList);
        }
        return listFound;
    }

    private List<Event> searchInListByOrganizerName(List<Event> eventsList) throws IOException {
        String organizerName = typeWhatYouNeed();
      /* *//* for (Event event : eventsList) {
            if (event.getOrganizer().getDesignation().toUpperCase().contains(organizerName.toUpperCase())) ;
            listFound.add(event);
        }*/
        listFound = eventsList.stream()
                .map(Event::getOrganizer)
                .map(Organizer::getDesignation)
                .filter(o -> o.contains(organizerName))
                .collect(Collector)

        if (listFound.isEmpty()) {
            System.out.println("Nie znaleziono żadnych wyników");
            searchInListByOrganizerName(eventsList);
        }
        return listFound;
    }
}