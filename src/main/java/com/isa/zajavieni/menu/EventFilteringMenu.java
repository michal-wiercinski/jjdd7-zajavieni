package com.isa.zajavieni.menu;

import com.isa.zajavieni.jsonclasses.Event;
import com.isa.zajavieni.jsonclasses.Organizer;
import com.isa.zajavieni.repository.EventList;
import com.isa.zajavieni.service.EventFilter;
import com.isa.zajavieni.service.EventPrinter;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class EventFilteringMenu {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001b[33;1m";

    public void filter() throws IOException {
        EventFilter eventFilter = new EventFilter();
        EventPrinter eventPrinter = new EventPrinter();
        eventPrinter.printListOfEvents(eventFilter.filterEventsList(EventList.getEventList(), enterStartDate(),
                enterEndDate(), enterNameOfOrganizer()));
    }


    private Date enterStartDate() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz datę początkową filtrowania (RRRR-MM-DD): ");
        Date startDate = null;
        Pattern datePattern = compile("[1-2][0,1,9][0-9][0-9]\\-[0-1][0-9]\\-[0-3][0-9]");
        do {
            String startDateString = scanner.nextLine();
            Matcher matcher = datePattern.matcher(startDateString);
            if (matcher.matches()) {
                startDate = formatDate(startDateString);
            } else {
                returnToSearch();
            }
        } while (startDate == null);
        return startDate;
    }

    private Date enterEndDate() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz datę końcową filtrowania (RRRR-MM-DD): ");
        Date endDate = null;
        Pattern datePattern = compile("[1-2][0,1,9][0-9][0-9]\\-[0-1][0-9]\\-[0-3][0-9]");
        do {
            String endDateString = scanner.nextLine();
            Matcher matcher = datePattern.matcher(endDateString);
            if (matcher.matches()) {
                endDate = formatDate(endDateString);
            } else {
                returnToSearch();
            }
        } while (endDate == null);
        System.out.println(ANSI_YELLOW + "Nazwy organizatorów:" + ANSI_RESET);
        printOrganizerList(EventList.getEventList());
        return endDate;
    }

    private void printOrganizerList(List<Event> eventList) throws IOException {
        List<String> organizersList = new ArrayList<>();
        for (Event event : eventList) {
            if (!organizersList.contains(event.getOrganizer().getDesignation())) {
                organizersList.add(event.getOrganizer().getDesignation());
            }
        }
        int counter = 1;
        for (String organizer : organizersList) {
            System.out.println(ANSI_YELLOW + counter + "." + " " + ANSI_RESET + organizer);
            counter++;
        }
    }

    private List<String> enterNameOfOrganizer() throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<String> organizersList = new ArrayList<>();
        boolean isSearchFinished = false;
        do {
            System.out.println("Podaj nazwę organizatora z listy:");
            String organizer = scanner.nextLine();
            boolean isParticularOrganizerFound = false;
            for (int i = 0; i < EventList.getEventList().size(); i++) {
                if (organizer.toLowerCase().replaceAll("\\s", "").equals(EventList.getEventList()
                        .get(i).getOrganizer().getDesignation().toLowerCase().replaceAll("\\s", ""))) {
                    organizersList.add(organizer);
                    isParticularOrganizerFound = true;
                    break;
                }
            }
            if (isParticularOrganizerFound == false) {
                System.out.println("Nie ma organizatora " + organizer + " na liście wydarzeń.");
            }
            System.out.println("Czy chcesz dodac kolejengo organizatora? (t/n)");
            String choice = scanner.nextLine();
            switch (choice) {
                case "t":
                    break;
                case "n":
                    isSearchFinished = true;
                    break;
                default:
                    System.out.println("Wpisałeś coś niewłaściwego, wybierz t lub n");
                    scanner.nextLine();
                    continue;
            }
        } while (isSearchFinished == false);
        return organizersList;
    }

    private Date formatDate(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date formatDate = null;
        try {
            formatDate = formatter.parse(date);
        } catch (ParseException e) {
            System.out.println("Wystąpił błąd formatowania!");
        }
        return formatDate;
    }
    private void returnToSearch() throws IOException {
        System.out.println("Wpisano zły format daty. Czy chcesz kontynuować filtrowanie? T / N");
        Scanner scanner = new Scanner(System.in);
        String yesOrNot = scanner.nextLine();
        if (yesOrNot.equalsIgnoreCase("n")) {
            new MainMenu().mainMenu();
        } else if (yesOrNot.equalsIgnoreCase("t")) {
            System.out.println("Podaj jeszcze raz datę w prawidłowym formacie RRRR-MM-DD: ");
        }
    }
}
