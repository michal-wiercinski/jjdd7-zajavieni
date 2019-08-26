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

public class UpdateEventForm {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public void askForEventFields(Event event) {
        Scanner scanner = new Scanner(System.in);

        String name = askForString(scanner, event.getName(), "Podaj nową nazwę");
        event.setName(name);

        String descShort = askForString(scanner, event.getDescShort(), "Podaj nowy krótki opis wydarzenia");
        event.setDescShort(descShort);

        String descLong = askForString(scanner, event.getDescLong(), "Podaj nowy długi opis wydarzenia");
        event.setDescLong(descLong);

        Date startDate = askForDate(scanner, event.getStartDate(), "Podaj nową datę rozpoczęcia");
        event.setStartDate(startDate);

        Date endDate = askForDate(scanner, event.getEndDate(), "Podaj nową datę zakończenia");
        event.setEndDate(endDate);

        Place place = askForPlace(scanner, event.getPlace());
        event.setPlace(place);

        MediaLink mediaLink = event.getMediaLink();

        String wwwAddress = askForString(scanner, mediaLink.getWwwAddress(), "Podaj nowy adres strony www");
        mediaLink.setWwwAddress(wwwAddress);

        String fbSite = askForString(scanner, mediaLink.getFbSite(), "Podaj nowy adres strony fb");
        mediaLink.setWwwAddress(fbSite);

        String websiteWithTickets = askForString(scanner, mediaLink.getWebsiteWithTickets(),
                "Podaj nowy adres strony z biletami");
        mediaLink.setWwwAddress(websiteWithTickets);

        event.setTicketType(TicketType.FREE);

        Organizer organizer = askForOrganizer(scanner, event.getOrganizer());
        event.setOrganizer(organizer);

        Long categoryId = askForCategory(scanner, event.getCategoryId());
        event.setCategoryId(categoryId);

    }

    private String askForString(Scanner scanner, String defaultValue, String label) {
        System.out.println(label + " [" + defaultValue + "]:");
        String value = scanner.nextLine();
        if (!value.isEmpty()) {
            return value;
        } else {
            return defaultValue;
        }
    }

    private Date askForDate(Scanner scanner, Date defaultValue, String label) {
        while (true) {
            try {
                String defaultDate = simpleDateFormat.format(defaultValue);
                System.out.println(label + " [" + defaultDate + "]:");
                String value = scanner.nextLine();
                if (!value.isEmpty()) {
                    return simpleDateFormat.parse(value);
                } else {
                    return defaultValue;
                }
            } catch (ParseException e) {
                System.out.println("Nieprawidłowy format daty.");
            }

        }
    }

    private Organizer askForOrganizer(Scanner scanner, Organizer defaultOrganizer) {
        OrganizersDao organizersDao = new OrganizersDao();
        OrganizerPrinter organizerPrinter = new OrganizerPrinter();
        organizerPrinter.printOrganizers(OrganizerList.getOrganizerList());
        while (true) {
            System.out.println("Podaj nowe id organizatora: [" + defaultOrganizer.getId() + "]:");
            String organizerIdAsString = scanner.nextLine();
            if (!organizerIdAsString.isEmpty()) {
                Long organizerId = Long.parseLong(organizerIdAsString);
                Optional<Organizer> organizerById = organizersDao.getOrganizerById(organizerId);
                if (organizerById.isEmpty()) {
                    System.out.println("Nie znaleziono organizatora o takim id. Podaj jeszcze raz id.");
                } else {
                    return organizerById.get();
                }
            } else {
                return defaultOrganizer;
            }
        }
    }

    private Long askForCategory(Scanner scanner, Long defaultValue) {
        CategoriesDao categoriesDao = new CategoriesDao();
        CategoryPrinter categoryPrinter = new CategoryPrinter();
        categoryPrinter.printCategories(CategoryList.getCategoryList());
        while (true) {
            System.out.println("Podaj nowe id kategorii: [" + defaultValue + "]:");
            String categoryIdAsString = scanner.nextLine();
            if (!categoryIdAsString.isEmpty()) {
                Long categoryId = Long.parseLong(categoryIdAsString);
                Optional<Category> categoryById = categoriesDao.getCategoryById(categoryId);
                if (categoryById.isEmpty()) {
                    System.out.println("Nie znaleziono kategorii o takim id. Podaj jeszcze raz id.");
                } else {
                    return categoryId;
                }
            } else {
                return defaultValue;
            }
        }
    }

    private Place askForPlace(Scanner scanner, Place defaultPlace) {
        PlacesDao placesDao = new PlacesDao();
        PlacePrinter placePrinter = new PlacePrinter();
        placePrinter.printPlaces(PlaceList.getPlaceList());
        while (true) {
            System.out.println("Podaj id nowego miejsce: [" + defaultPlace.getPlaceId() + "]:");
            String placeIdAsString = scanner.nextLine();
            if (!placeIdAsString.isEmpty()) {
                Long placeId = Long.parseLong(placeIdAsString);
                Optional<Place> placeById = placesDao.getPlaceById(placeId);
                if (placeById.isEmpty()) {
                    System.out.println("Nie znaleziono miejsca o takim id. Podaj jeszcze raz id.");
                } else {
                    return placeById.get();
                }
            } else {
                return defaultPlace;
            }
        }
    }
}
