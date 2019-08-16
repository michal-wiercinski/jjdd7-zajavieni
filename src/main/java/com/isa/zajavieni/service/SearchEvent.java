package com.isa.zajavieni.service;

import com.isa.zajavieni.jsonclasses.Event;
import com.isa.zajavieni.menu.MainMenu;
import com.isa.zajavieni.repository.EventList;
import com.isa.zajavieni.repository.OrganizerList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SearchEvent {
    public List<Event> listFound = new ArrayList<>();

    public void printSearchMenu() throws IOException {
        printTextSearchMenu();
        Scanner scanner = new Scanner(System.in);
        String whatYouWant = scanner.nextLine();
        printMenu(whatYouWant);
    }

    private void printMenu(String whatYouWant) throws IOException {
        PrinterEvents eventService = new PrinterEvents();
        OrganizerList organizerList = new OrganizerList();
        EventList eventList = new EventList();
        switch (whatYouWant) {
            case "1":
                eventService.printListOfEvents(searchInListByEventName(EventList.getEventList()));
                returnToSearch();
                break;
            case "2":
                eventService.printListOfEvents(searchInListByOrganizerName(EventList.getEventList()));
                returnToSearch();
                break;
            case "3":
                System.out.println("3. To będzie działać filtrowanie daty");
                break;
            case "4":
                new MainMenu().mainMenu();
                break;
            default:
                System.out.println("Prosze podac cyfre z zakresu submenu");
        }
    }

    private void printTextSearchMenu() {
        System.out.println("Po czym chcesz wyszukać wydarzenie?");
        System.out.println("1. Nazwa wydarzenia");
        System.out.println("2. Nazwa organizatora");
        System.out.println("3. Filtruj po dacie i organizatorze");
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
                .filter(e -> e.getName().toLowerCase().contains(eventName.toLowerCase()))
                .collect(Collectors.toList());
        printIfListIsEmpty(eventsList);
        return listFound;
    }

    private List<Event> searchInListByOrganizerName(List<Event> eventsList) throws IOException {
        String organizerName = typeWhatYouNeed();
        listFound = eventsList.stream()
                .filter(e -> e.getOrganizer().getDesignation().toLowerCase().contains(organizerName.toLowerCase()))
                .collect(Collectors.toList());
        printIfListIsEmpty(eventsList);
        return listFound;
    }

    private void printIfListIsEmpty(List<Event> eventsList) throws IOException {
        if (listFound.isEmpty()) {
            System.out.println("Nie znaleziono żadnych wyników");
            searchInListByOrganizerName(eventsList);
        }
    }

    private void returnToSearch() throws IOException {
        System.out.println("Czy chcesz kontynuować poszukiwania? T / N");
        Scanner scanner = new Scanner(System.in);
        String yesOrNot = scanner.nextLine();
        if (yesOrNot.equalsIgnoreCase("n")) {
            new MainMenu().mainMenu();
        } else if (yesOrNot.equalsIgnoreCase("t")) {
            printSearchMenu();
        }
    }
}