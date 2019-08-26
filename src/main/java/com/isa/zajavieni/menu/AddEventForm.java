package com.isa.zajavieni.menu;

import com.isa.zajavieni.jsonclasses.*;
import com.isa.zajavieni.repository.CategoryList;
import com.isa.zajavieni.repository.OrganizerList;
import com.isa.zajavieni.repository.PlaceList;
import com.isa.zajavieni.service.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;

public class AddEventForm {

    private EventsDao eventsDao = new EventsDao();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public Event askForEventFields() {
        Scanner scanner = new Scanner(System.in);
        Event event = new Event();

        Long id = eventsDao.getNextId();
        event.setEventId(id);

        String name = askForString(scanner, "Podaj nazwę");
        event.setName(name);

        String descShort = askForString(scanner, "Podaj opis");
        event.setDescShort(descShort);

        String descLong = askForString(scanner, "Podaj długi opis");
        event.setDescLong(descLong);

        event.setActive(true);

        Date startDate = askForDate(scanner, "Podaj datę rozpoczęcia w formacie YYYY-MM-DD HH:MM");
        event.setStartDate(startDate);

        Date endDate = askForDate(scanner, "Podaj datę zakończenia w formacie YYYY-MM-DD HH:MM");
        event.setEndDate(endDate);

        Place place = askForPlace(scanner);
        event.setPlace(place);

        MediaLink mediaLink = new MediaLink();

        String wwwAddress = askForString(scanner, "Podaj adres strony www");
        mediaLink.setWwwAddress(wwwAddress);

        String fbSite = askForString(scanner, "Podaj adres strony fb");
        mediaLink.setFbSite(fbSite);

        String websiteWithTickets = askForString(scanner, "Podaj adres strony z biletami");
        mediaLink.setWebsiteWithTickets(websiteWithTickets);

        event.setMediaLink(mediaLink);

        event.setTicketType(TicketType.FREE);

        Organizer organizer = askForOrganizer(scanner);
        event.setOrganizer(organizer);

        long categoryId = askForCategory(scanner);
        event.setCategoryId(categoryId);

        return event;
    }

    private String askForString(Scanner scanner, String label) {
        System.out.println(label + ": ");
        return scanner.nextLine();
    }

    private Date askForDate(Scanner scanner, String label) {

        while (true) {
            try {
                String stringStartDate = askForString(scanner, label);
                return simpleDateFormat.parse(stringStartDate);
            } catch (ParseException e) {
                System.out.println("Nieprawidłowy format daty.");
            }
        }
    }

    private Place askForPlace(Scanner scanner) {
        PlacesDao placesDao = new PlacesDao();
        PlacePrinter placePrinter = new PlacePrinter();
        placePrinter.printPlaces(PlaceList.getPlaceList());
        while (true) {
            Long placeId = askForLong(scanner, "Podaj id miejsca");
            Optional<Place> placeById = placesDao.getPlaceById(placeId);
            if (placeById.isEmpty()) {
                System.out.println("Nie znaleziono miejsca o takim id. Podaj jeszcze raz id.");
            } else {
                return placeById.get();
            }
        }
    }

    private Long askForLong(Scanner scanner, String label) {
        System.out.println(label + ": ");
        Long value = scanner.nextLong();
        scanner.nextLine();
        return value;
    }

    private Organizer askForOrganizer(Scanner scanner) {
        OrganizersDao organizersDao = new OrganizersDao();
        OrganizerPrinter organizerPrinter = new OrganizerPrinter();
        organizerPrinter.printOrganizers(OrganizerList.getOrganizerList());
        while (true) {
            Long organizerId = askForLong(scanner, "Podaj id organizatora");
            Optional<Organizer> organizerById = organizersDao.getOrganizerById(organizerId);
            if (organizerById.isEmpty()) {
                System.out.println("Nie znaleziono organizatora o takim id. Podaj jeszcze raz id.");
            } else {
                return organizerById.get();
            }
        }
    }

    private long askForCategory(Scanner scanner) {
        CategoriesDao categoriesDao = new CategoriesDao();
        CategoryPrinter categoryPrinter = new CategoryPrinter();
        categoryPrinter.printCategories(CategoryList.getCategoryList());
        while (true) {
            Long categoryId = askForLong(scanner, "Podaj id kategorii");
            Optional<Category> categoryById = categoriesDao.getCategoryById(categoryId);
            if (categoryById.isEmpty()) {
                System.out.println("Nie znaleziono kategorii o takim id. Podaj jeszcze raz id.");
            } else {
                return categoryId;
            }
        }
    }

}
