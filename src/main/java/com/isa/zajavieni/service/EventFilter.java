package com.isa.zajavieni.service;

import com.isa.zajavieni.jsonclasses.Event;
import java.util.*;
import java.util.stream.Collectors;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EventFilter {

    public List<Event> filterEventsList(List<Event> eventList, Date upDate, Date toDate, List<String> organizers) {
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

     /*
    private Comparator<Event> getComparatorByProperties() {
        Comparator<Event> comparator = Comparator.comparing(Event::getStartDate);

        try (InputStream input = new FileInputStream("path/to/config.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            prop.getProperty(
            System.out.println(prop.getProperty("db.user"));
            System.out.println(prop.getProperty("db.password"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}




        if (asc) {
            return comparator;
        }
        return comparator.reversed();
    }*/

    public List<Event> sortedAndFilteredEventsList(List<Event> filterEventsList) {
        List<Event> sortedFinalList = new ArrayList<>();
        List<Event> sortingList = filterEventsList.stream()
                .sorted(Comparator.comparing(Event::getStartDate).reversed())
                .collect(Collectors.toList());
        sortedFinalList.addAll(sortingList);
        return sortedFinalList;
    }
}

