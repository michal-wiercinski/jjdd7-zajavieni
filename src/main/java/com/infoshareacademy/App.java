package com.infoshareacademy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static List<Event> listOfEvents = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        listOfEvents = new DomainDeserializer().deserializeEvents("events.json");
        new NewMenu.Menu().mainMenu();
    }
}