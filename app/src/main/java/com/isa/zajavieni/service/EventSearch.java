package com.isa.zajavieni.service;

import com.isa.zajavieni.jsonclasses.Event;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
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

    private Comparator<Event> getComparatorByForEventsNameProperties() {
        Comparator<Event> comparator = Comparator.comparing(Event::getStartDate);

        Properties prop = new Properties();

        try (InputStream input = new FileInputStream("/home/mwiercinski/jjdd7-zajavieni/src/resources/zajavieni.properties")) {

            prop.load(input);
            String propertiesOrder = prop.getProperty("sortEventName");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        String propertiesOrder = prop.getProperty("sortEventName");
        if (propertiesOrder.equals("ASC")) {
            return comparator;
        }
        return comparator.reversed();
    }

    public List<Event> sortedByPropertiesSearchInListByEventName(List<Event> searchInListByEventName) {
        List<Event> sortedFinalList = new ArrayList<>();
        List<Event> sortingList = searchInListByEventName.stream()
                .sorted(getComparatorByForEventsNameProperties())
                .collect(Collectors.toList());
        sortedFinalList.addAll(sortingList);
        return sortedFinalList;
    }

    public List<Event> searchInListByOrganizerName(List<Event> eventsList, String name) throws IOException {
        listFound = eventsList.stream()
                .filter(e -> e.getOrganizer().getDesignation().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
        printIfListIsEmpty(eventsList);
        return listFound;
    }

    private Comparator<Event> getComparatorForOrganizersByProperties() {
        Comparator<Event> comparator = Comparator.comparing(Event::getStartDate);

        Properties prop = new Properties();

        try (InputStream input = new FileInputStream("/home/mwiercinski/jjdd7-zajavieni/src/resources/zajavieni.properties")) {

            prop.load(input);
            String propertiesOrder = prop.getProperty("sortOrganizerName");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        String propertiesOrder = prop.getProperty("sortOrganizerName");
        if (propertiesOrder.equals("ASC")) {
            return comparator;
        }
        return comparator.reversed();
    }

    public List<Event> sortedByPropertiesSearchInListByOrganizerName(List<Event> searchInListByOrganizerName) {
        List<Event> sortedFinalList = new ArrayList<>();
        List<Event> sortingList = searchInListByOrganizerName.stream()
                .sorted(getComparatorForOrganizersByProperties())
                .collect(Collectors.toList());
        sortedFinalList.addAll(sortingList);
        return sortedFinalList;
    }


    private void printIfListIsEmpty(List<Event> eventsList) throws IOException {
        if (listFound.isEmpty()) {
            System.out.println("Nie znaleziono żadnych wyników");
            sortedByPropertiesSearchInListByEventName(eventsList);

        }
    }
}