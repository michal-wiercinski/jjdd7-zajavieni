package com.isa.zajavieni.service;

import com.isa.zajavieni.jsonclasses.Event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EventSearch {
    public List<Event> listFound = new ArrayList<>();

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

    public List<Event> searchInListByEventName(List<Event> eventsList) throws IOException {
        String eventName = typeWhatYouNeed();
        listFound = eventsList.stream()
                .filter(e -> e.getName().toLowerCase().contains(eventName.toLowerCase()))
                .collect(Collectors.toList());
        printIfListIsEmpty(eventsList);
        return listFound;
    }

    public List<Event> searchInListByOrganizerName(List<Event> eventsList) throws IOException {
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
}