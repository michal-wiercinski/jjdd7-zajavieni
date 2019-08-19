package com.isa.zajavieni.service;

import com.isa.zajavieni.jsonclasses.Event;
import com.isa.zajavieni.menu.MainMenu;
import com.isa.zajavieni.repository.EventList;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.regex.Pattern.compile;

public class FiltrEvents {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001b[33;1m";

    public void filtr() throws IOException {
        PrinterEvents printerEvents = new PrinterEvents();
        printerEvents.printListOfEvents(filtrEvents(EventList.getEventList(), enterStartDate(), enterEndDate(), enterOrganizer()));
        whatDoYouWant();

    }

    private void whatDoYouWant() throws IOException {
        System.out.println("Co chcesz teraz zrobić? ");
        System.out.println("1. Kontynuuj filtrowanie.");
        System.out.println("2. Wróć do wyrzukiwania.");
        System.out.println("3. Wróć do głównego menu.");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                filtr();
                break;
            case "2":
                new SearchEvent().printSearchMenu();
                break;
            case "3":
                new MainMenu().mainMenu();
                break;
            default:
                System.out.println("Wpisałeś coś niewłaściwego, wybierz liczbę z zakresu menu.");
                whatDoYouWant();
        }
    }

    private Date enterStartDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz datę początkową filtrowania (RRRR-MM-DD): ");
        Date startDate = null;
        Pattern datePattern = compile("[1-2][0,1,9][0-9][0-9]\\-[0-1][0-9]\\-[0-3][0-9]");
        do {
            String startDateString = scanner.nextLine();
            Matcher matcher = datePattern.matcher(startDateString);
            if (matcher.matches()) {
                startDate = dateFormater(startDateString);
            } else {
                System.out.println("Wpisano zły format daty. Wpisz ponownie datę w formacie: RRRR-MM-DD");
            }

        } while (startDate == null);
        return startDate;
    }

    private Date enterEndDate() throws IOException {
        EventList eventList = new EventList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz datę końcową filtrowania (RRRR-MM-DD): ");
        Date endDate = null;
        Pattern datePattern = compile("[1-2][0,1,9][0-9][0-9]\\-[0-1][0-9]\\-[0-3][0-9]");
        do {
            String endDateString = scanner.nextLine();
            Matcher matcher = datePattern.matcher(endDateString);
            if (matcher.matches()) {
                endDate = dateFormater(endDateString);
            } else {
                System.out.println("Wpisano zły format daty. Wpisz ponownie datę w formacie: RRRR-MM-DD");
            }

        } while (endDate == null);
        System.out.println(ANSI_YELLOW + "Nazwy organizatorów:" + ANSI_RESET);
        printerOrganizerList(eventList.getEventList());
        return endDate;

    }

    private void printerOrganizerList(List<Event> eventList) throws IOException {
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

    private List<String> enterOrganizer() throws IOException {
        Scanner scanner = new Scanner(System.in);
        EventList eventList = new EventList();
        List<String> organizersList = new ArrayList<>();
        boolean isEndOfFinding = false;
        do {
            System.out.println("Podaj nazwę organizatora z listy:");
            String organizer = scanner.nextLine();
            boolean isParticularOrganizerFound = false;
            for (int i = 0; i < EventList.getEventList().size(); i++) {
                if (organizer.toLowerCase().replaceAll("\\s", "").equals(eventList.getEventList()
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
                    isEndOfFinding = true;
                    break;
                default:
                    System.out.println("Wpisałeś coś niewłaściwego, wybierz t lub n");
                    scanner.nextLine();
                    continue;
            }

        } while (isEndOfFinding == false);
        return organizersList;
    }

    private Date dateFormater(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date formatDate = null;
        try {
            formatDate = formatter.parse(date);
        } catch (ParseException e) {
            System.out.println("Wystąpił błąd formatowania!");
        }
        return formatDate;
    }

    private List<Event> filtrEvents(List<Event> eventList, Date upDate, Date toDate, List<String> organizers) {
        Collections.sort(organizers);
        List<Event> finalList = new ArrayList<>();
        for (String organizer : organizers) {
            List<Event> foundList = eventList.stream()
                    .filter(e -> e.getStartDate().compareTo(upDate) >= 0)
                    .filter(e -> e.getStartDate().compareTo(toDate) <= 0)
                    .filter(e -> e.getOrganizer().getDesignation().toLowerCase().replaceAll("\\s", "")
                            .contains(organizer.toLowerCase().replaceAll("\\s", "")))
                    .collect(Collectors.toList());
            finalList.addAll(foundList);
        }
        if (finalList.isEmpty()) {
            System.out.println("Brak wydarzeń w danym przedziale czasu");
        }
        return finalList;
    }

}

