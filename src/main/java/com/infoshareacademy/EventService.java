package com.infoshareacademy;

import java.io.IOException;
import java.util.List;

public class EventService {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";

    public void printListOfEvents() throws IOException {
        DomainDeserializer domainDeserializer = new DomainDeserializer();
        List<Event> listOfEvents = domainDeserializer.deserializeEvents("events.json");
        int counter = 1;
        for (Event event : listOfEvents) {
            System.out.println(ANSI_GREEN + counter + "." + "\tNazwa wydarzenia: " + ANSI_RESET + event.getName() +
                    ANSI_GREEN + "\n\tMiejsce: " + ANSI_RESET + event.getPlace().getName() + ANSI_GREEN + "\n\tData startu: "
                    + ANSI_RESET + event.getStartDate() + ANSI_GREEN + "\n\tNazwa Organizatora: " + ANSI_RESET + event.getOrganizer().getDesignation() + "\n");
            counter++;
        }
    }
}