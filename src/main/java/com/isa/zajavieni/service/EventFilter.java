package com.isa.zajavieni.service;

import com.isa.zajavieni.jsonclasses.Event;
import com.isa.zajavieni.menu.EventSearchingMenu;
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
}

