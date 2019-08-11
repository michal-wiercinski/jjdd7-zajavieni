package com.infoshareacademy;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {

        System.out.println("Zajavieni");

        EventService eventService = new EventService();
        eventService.printListOfEvents();

    }
}
