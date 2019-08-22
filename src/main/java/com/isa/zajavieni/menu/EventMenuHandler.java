package com.isa.zajavieni.menu;

import com.isa.zajavieni.jsonclasses.Address;
import com.isa.zajavieni.jsonclasses.Event;
import com.isa.zajavieni.jsonclasses.Organizer;
import com.isa.zajavieni.jsonclasses.Place;
import com.isa.zajavieni.repository.OrganizerChooser;
import com.isa.zajavieni.repository.PlaceChooser;
import com.isa.zajavieni.service.EventsDao;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class EventMenuHandler {

    public void printEventMenu() throws IOException {
        printTextMenu();
        Scanner scanner = new Scanner(System.in);
        String choiceEventMenu = scanner.nextLine();
        choiceEventMenu(choiceEventMenu);
    }

    private void printTextMenu() {
        System.out.println("Zarządzanie wydarzeniami.");
        System.out.println("1. Usuń wydarzenie");
        System.out.println("2. Dodaj wydarzenie <<W budowie>>");
        System.out.println("3. Edytuj wydarzenie <<W budowie>>");
        System.out.println("4. Wróć do głównego menu");
    }

    private void choiceEventMenu(String choice) throws IOException {
        Scanner scanner = new Scanner(System.in);
        switch (choice) {
            case "1":
                System.out.println("Podaj ID wydarzenia, które chcesz usunąć:");
                Long eventsIdToRemove = scanner.nextLong();
                EventsDao eventsDao = new EventsDao();
                eventsDao.removeEventById(eventsIdToRemove);
                break;
            case "2":
                System.out.println("Podaj dane: <<W budowie>>");
                break;
            case "3":
                System.out.println("Edytuj dane: <<W budowie>>");
                break;
            case "4":
                return;
            default:
                System.out.println("Proszę podać cyfrę z zakresu menu");
        }
    }

    public Event setEventFieldsToAdd(){

        Scanner scanner= new Scanner(System.in);
        Event event = new Event();
        System.out.println("Wydarzenie");
        System.out.println("Podaj id");
        event.setEventId(scanner.nextLong());
        System.out.println("Podaj nazwę");
        event.setName(scanner.nextLine());
        System.out.println("Podaj opis");
        event.setDescShort(scanner.nextLine());
        System.out.println("Podaj długi opis");
        event.setDescLong(scanner.nextLine());
        event.setActive(true);
        System.out.println("Podaj datę rozpoczęcia");
        event.setStartDate(new Date());
        System.out.println("Podaj datę zakończenia");
        event.setEndDate(new Date());

        PlaceChooser placeChooser = new PlaceChooser();
        event.setPlace(placeChooser.placeChoose());

        OrganizerChooser organizerChooser = new OrganizerChooser();
        event.setOrganizer(organizerChooser.organizerChoose());

        return event;
    }
}
