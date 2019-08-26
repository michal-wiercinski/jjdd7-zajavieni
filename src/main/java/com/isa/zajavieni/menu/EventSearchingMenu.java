package com.isa.zajavieni.menu;

import com.isa.zajavieni.repository.EventList;
import com.isa.zajavieni.service.EventPrinter;
import com.isa.zajavieni.service.EventSearch;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class EventSearchingMenu {
    public void printSearchMenu() throws IOException, ParseException {
        printTextSearchMenu();
        Scanner scanner = new Scanner(System.in);
        String whatYouWant = scanner.nextLine();
        printMenu(whatYouWant);
    }

    private void printTextSearchMenu() {
        System.out.println("Po czym chcesz wyszukać wydarzenie?");
        System.out.println("1. Nazwa wydarzenia");
        System.out.println("2. Nazwa organizatora");
        System.out.println("3. Filtruj po dacie i organizatorze");
        System.out.println("4. Wróć do głównego menu");
    }

    private void printMenu(String whatYouWant) throws IOException, ParseException {
        EventPrinter eventService = new EventPrinter();
        EventSearch eventSearch = new EventSearch();
        switch (whatYouWant) {
            case "1":
                eventService.printListOfEvents(eventSearch
                        .searchInListByEventName(EventList.getEventList(), typeWhatYouNeed()));
                returnToSearch();
                break;
            case "2":
                eventService.printListOfEvents(eventSearch
                        .searchInListByOrganizerName(EventList.getEventList(), typeWhatYouNeed()));
                returnToSearch();
                break;
            case "3":
                new EventFilteringMenu().filter();
                returnToSearch();
                break;
            case "4":
                new MainMenu().mainMenu();
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

    private void returnToSearch() throws IOException, ParseException {
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