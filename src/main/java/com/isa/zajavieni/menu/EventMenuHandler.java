package com.isa.zajavieni.menu;

import com.isa.zajavieni.jsonclasses.Event;
import com.isa.zajavieni.repository.FavouriteEventList;
import com.isa.zajavieni.service.ConsoleCleaner;
import com.isa.zajavieni.service.EventsDao;

import com.isa.zajavieni.service.FavouriteEventPrinter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Optional;
import java.util.Scanner;

public class EventMenuHandler {

    private EventsDao eventsDao = new EventsDao();

    public void printEventMenu() throws IOException, ParseException {
        printTextMenu();
        Scanner scanner = new Scanner(System.in);
        String choiceEventMenu = scanner.nextLine();
        choiceEventMenu(choiceEventMenu);
    }

    private void printTextMenu() throws IOException {
        ConsoleCleaner.cleanConsole();
        FavouriteEventPrinter favouriteEventPrinter = new FavouriteEventPrinter();
        favouriteEventPrinter.printFavouriteEvent(FavouriteEventList.getFavouriteEventList());
        System.out.println("\tZarządzanie wydarzeniami.");
        System.out.println("\t1. Dodaj wydarzenie");
        System.out.println("\t2. Edytuj wydarzenie");
        System.out.println("\t3. Usuń wydarzenie");
        System.out.println("\t4. Wróć do głównego menu");
    }

    private void choiceEventMenu(String choice) throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);
        switch (choice) {
            case "1":
                executeEventAdd();
                break;
            case "2":
                executeEventUpdate(scanner);
                break;
            case "3":
                executeEventDelete(scanner);
                break;
            case "4":
                return;
            default:
                System.out.println("Proszę podać cyfrę z zakresu menu");
        }
    }

    private void executeEventAdd() throws IOException {
        System.out.println("Podaj dane wydarzenia");
        AddEventForm addEventForm = new AddEventForm();
        Event eventToAdd = addEventForm.askForEventFields();
        eventsDao.addEvent(eventToAdd);
        System.out.println("Dodano wydarzenie o id = " + eventToAdd.getEventId());
    }

    private void executeEventUpdate(Scanner scanner) throws IOException {
        System.out.println("Podaj id wydarzenia, które chcesz edytować");
        Long eventIdToUpdate = scanner.nextLong();
        Optional<Event> eventById = eventsDao.getEventById(eventIdToUpdate);
        if (eventById.isEmpty()) {
            System.out.println("Nie znaleziono wydarzenia, lista wydarzeń bez zmian.");
        } else {
            Event event = eventById.get();
            UpdateEventForm updateEventForm = new UpdateEventForm();
            updateEventForm.askForEventFields(event);
            eventsDao.updateEvent(event);
            System.out.println("Zedytowano wydarzenie");
        }
    }

    private void executeEventDelete(Scanner scanner) throws IOException {
        System.out.print("Podaj ID wydarzenia, które chcesz usunąć: ");
        Long eventsIdToRemove = scanner.nextLong();
        Optional<Event> eventToRemove = eventsDao.getEventById(eventsIdToRemove);
        if (eventToRemove.isEmpty()) {
            System.out.println("Nie znaleziono wydarzenia, lista wydarzeń bez zmian.");
        } else {
            eventsDao.removeEventById(eventsIdToRemove);
            System.out.println("Usunięto wydarzenie.");
        }
    }
}