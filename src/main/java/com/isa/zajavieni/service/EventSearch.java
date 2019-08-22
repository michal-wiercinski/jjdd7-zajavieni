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

public class EventSearch {
    public List<Event> listFound = new ArrayList<>();



    public List<Event> searchInListByEventName(List<Event> eventsList, String name) throws IOException {
        listFound = eventsList.stream()
                .filter(e -> e.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
        printIfListIsEmpty(eventsList);
        return listFound;
    }

    public List<Event> searchInListByOrganizerName(List<Event> eventsList, String name) throws IOException {
        listFound = eventsList.stream()
                .filter(e -> e.getOrganizer().getDesignation().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
        printIfListIsEmpty(eventsList);
        return listFound;
    }

    private void printIfListIsEmpty(List<Event> eventsList) throws IOException {
        if (listFound.isEmpty()) {
            System.out.println("Nie znaleziono żadnych wyników");
            return;
        }
    }
}