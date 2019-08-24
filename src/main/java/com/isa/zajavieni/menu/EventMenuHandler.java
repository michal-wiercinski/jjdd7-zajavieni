package com.isa.zajavieni.menu;

import com.isa.zajavieni.jsonclasses.*;
import com.isa.zajavieni.service.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;
import java.util.TimeZone;

public class EventMenuHandler {

    private EventsDao eventsDao = new EventsDao();

    public void printEventMenu() throws IOException, ParseException {
        printTextMenu();
        Scanner scanner = new Scanner(System.in);
        String choiceEventMenu = scanner.nextLine();
        choiceEventMenu(choiceEventMenu);
    }

    private void printTextMenu() {
        System.out.println("Zarządzanie wydarzeniami.");
        System.out.println("1. Usuń wydarzenie");
        System.out.println("2. Dodaj wydarzenie");
        System.out.println("3. Edytuj wydarzenie <<W budowie>>");
        System.out.println("4. Wróć do głównego menu");
    }

    private void choiceEventMenu(String choice) throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);
        switch (choice) {
            case "1":
                System.out.print("Podaj ID wydarzenia, które chcesz usunąć: ");
                Long eventsIdToRemove = scanner.nextLong();
                Optional<Event> eventToRemove = eventsDao.getEventById(eventsIdToRemove);
                if (eventToRemove.isEmpty()) {
                    System.out.println("Nie znaleziono wydarzenia, lista wydarzeń bez zmian.");
                } else {
                    eventsDao.removeEventById(eventsIdToRemove);
                    System.out.println("Usunięto wydarzenie.");
                }
                break;
            case "2":
                System.out.println("Podaj dane wydarzenia");
                Event eventToAdd = askForEventFields();
                eventsDao.addEvent(eventToAdd);
                System.out.println("Dodano wydarzenie.");
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

    public Event askForEventFields() throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);
        Event event = new Event();
        System.out.println("Podaj id: ");
        event.setEventId(scanner.nextLong());
        scanner.nextLine();
        System.out.println("Podaj nazwę");
        event.setName(scanner.nextLine());
        System.out.println("Podaj opis");
        event.setDescShort(scanner.nextLine());
        System.out.println("Podaj długi opis");
        event.setDescLong(scanner.nextLine());
        event.setActive(true);

        System.out.println("Podaj datę rozpoczęcia w formacie YYYY-MM-DD HH:MM:SS");
        String stringStartDate = scanner.nextLine();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date startDate = simpleDateFormat.parse(stringStartDate);
        event.setStartDate(startDate);

        System.out.println("Podaj datę zakończenia w formacie YYYY-MM-DD HH:MM:SS");
        String stringEndDate = scanner.nextLine();
        Date endDate = simpleDateFormat.parse(stringEndDate);
        event.setStartDate(endDate);

        PlacesDao placesDao = new PlacesDao();
        PlacePrinter placePrinter = new PlacePrinter();
        placePrinter.printPlaces(placesDao.getPlaces());
        while (true) {
            System.out.println("Podaj id miejsca:");
            Long placeId = scanner.nextLong();
            scanner.nextLine();
            Optional<Place> placeById = placesDao.getPlaceById(placeId);
            if (placeById.isEmpty()) {
                System.out.println("Nie znaleziono miejsca o takim id. Podaj jeszcze raz id.");
            } else {
                event.setPlace(placeById.get());
                break;
            }
        }

        System.out.println("Podaj adres strony www");
        MediaLink mediaLink = new MediaLink();
        mediaLink.setWwwAddress(scanner.nextLine());
        System.out.println("Podaj adres strony fb");
        mediaLink.setFbSite(scanner.nextLine());
        System.out.println("Podaj adres strony z biletami");
        mediaLink.setWebsiteWithTickets(scanner.nextLine());
        event.setMediaLink(mediaLink);

        event.setTicketType(TicketType.FREE);

        OrganizersDao organizersDao = new OrganizersDao();
        OrganizerPrinter organizerPrinter = new OrganizerPrinter();
        organizerPrinter.printOrganizers(organizersDao.getOrganizers());
        while (true) {
            System.out.println("Podaj id organizatora:");
            Long organizerId = scanner.nextLong();
            scanner.nextLine();
            Optional<Organizer> organizerById = organizersDao.getOrganizerById(organizerId);
            if (organizerById.isEmpty()) {
                System.out.println("Nie znaleziono organizatora o takim id. Podaj jeszcze raz id.");
            } else {
                event.setOrganizer(organizerById.get());
                break;
            }
        }

        CategoriesDao categoriesDao = new CategoriesDao();
        CategoryPrinter categoryPrinter = new CategoryPrinter();
        categoryPrinter.printCategories(categoriesDao.getCategories());
        while (true) {
            System.out.println("Podaj id kategorii:");
            Long categoryId = scanner.nextLong();
            scanner.nextLine();
            Optional<Category> categoryById = categoriesDao.getCategoryById(categoryId);
            if (categoryById.isEmpty()) {
                System.out.println("Nie znaleziono kategorii o takim id. Podaj jeszcze raz id.");
            } else {
                event.setCategoryId(categoryId);
                break;
            }
        }
        return event;
    }
}