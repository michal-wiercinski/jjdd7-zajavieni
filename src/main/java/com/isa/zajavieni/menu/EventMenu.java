package com.isa.zajavieni.menu;

import com.isa.zajavieni.service.EventsDao;

import java.io.IOException;
import java.util.Scanner;

public class EventMenu {

    public void eventMenu() throws IOException {
        EventMenu daoMenu = new EventMenu();
        daoMenu.printEventMenu();
        Scanner scanner = new Scanner(System.in);
        String choiceEventMenu = scanner.nextLine();
        daoMenu.choiceEventMenu(choiceEventMenu);
    }

    public void printEventMenu() {
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
                Long s = scanner.nextLong();
                EventsDao eventsDao = new EventsDao();
                eventsDao.deleteEvent(s);
                break;
            case "2":
                System.out.println("Podaj dane: <<W budowie>>");
                break;
            case "3":
                System.out.println("Edytuj dane: <<W budowie>>");
                break;
            case "4":
                new MainMenu().mainMenu();
                break;
            default:
                System.out.println("Proszę podać cyfrę z zakresu menu");
        }
    }
}
