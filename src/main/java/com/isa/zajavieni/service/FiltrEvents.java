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

import static java.util.regex.Pattern.compile;

public class FiltrEvents {

    public void filtr() throws IOException {
        Scanner scanner = new Scanner(System.in);
        PrinterEvents printerEvents = new PrinterEvents();
        printerEvents.printListOfEvents(filtrEvents(EventList.getEventList(), enterStartDate(), enterEndDate(), enterOrganizers()));
        System.out.println("Czy chcesz kontynuować filtrowanie? ");
        System.out.println("1. Kontynuuj filtrowanie.");
        System.out.println("2. Wróć do wyrzukiwania.");
        System.out.println("3. Wróć do głównego menu.");
        String choice = scanner.nextLine();
        switch(choice){
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
                System.out.println("Proszę wybrać tak(t) lub nie(n)");

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

    private Date enterEndDate() {
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
        return endDate;

    }

    private List<String> enterOrganizers() throws IOException {
        EventList eventList = new EventList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj co najmniej jednego lub więcej organizatorów:");
        boolean isAnyOrganizerFound = false;
        List<String> organizersList = null;
        do {
            String organizers = scanner.nextLine();
            organizersList = new ArrayList<String>(Arrays.asList(organizers.split(",")));
            for (int i = 0; i < organizersList.size(); i++) {
                boolean isParticularOrganizerFound = false;
                for (int j = 0; j < EventList.getEventList().size(); j++) {
                    if (organizersList.get(i).toLowerCase().replaceAll("\\s", "").equals(eventList.getEventList().get(j).getOrganizer().getDesignation().toLowerCase().replaceAll("\\s", ""))) {
                        isAnyOrganizerFound = true;
                        isParticularOrganizerFound = true;
                    }
                }
                if (isParticularOrganizerFound == false) {
                    System.out.println("Nie ma organizatora " + organizersList.get(i) + " na liście wydarzeń. Wpisz ponownie nazwę organizatora.");
                }
            }
        } while (isAnyOrganizerFound == false);
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


    private List<Event> filtrEvents(List<Event> eventList, Date upDate, Date toDate, List<String> organizers) throws IOException {
        Collections.sort(organizers);
        List<Event> foundList = new ArrayList<>();
//        eventList.stream()
//                .filter(//start date >=)
//                .filter(//end date <=)
//                .filter(list.contains(event.organizer))
        for (String organizer : organizers)
            for (Event event : eventList) {
                if (event.getStartDate().compareTo(upDate) >= 0 && event.getStartDate().compareTo(toDate) <= 0 &&
                        event.getOrganizer().getDesignation().toLowerCase().replaceAll("\\s", "").equals(organizer.toLowerCase().replaceAll("\\s", ""))) {
                    foundList.add(event);
                }
            }
        if(foundList.isEmpty()){
            System.out.println("Brak wydarzeń w danym przedziale czasu");
        }
        return foundList;
    }


/*
    private List<Event> filtrEvents(List<Event> eventList, Date upDate, Date toDate, List<String> organizers) throws IOException {
        Collections.sort(organizers);
        foundList = eventList.stream()
                .filter(e->e.getOrganizer().getDesignation().toLowerCase().replaceAll("\\s", "").contains(organizers))
        for (String organizer : organizers)
            for (Event event : eventList) {
                if (event.getStartDate().compareTo(upDate) >= 0 && event.getStartDate().compareTo(toDate) <= 0 &&
                        event.getOrganizer().getDesignation().toLowerCase().replaceAll("\\s", "").equals(organizer.toLowerCase().replaceAll("\\s", ""))) {
                    foundList.add(event);
                }
            }
        if(foundList.equals(Collections.emptyList())){
            System.out.println("Brak wydarzeń z danego okresu");

            filtr();
        }
        return foundList;
    }

 */


}
