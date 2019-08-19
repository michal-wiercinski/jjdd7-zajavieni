package com.isa.zajavieni.menu;

import com.isa.zajavieni.service.EventsDao;

import java.io.IOException;
import java.util.Scanner;

public class DaoMenu {

    public static void main(String[] args) throws IOException {
        DaoMenu daoMenu = new DaoMenu();
        daoMenu.daoMenu();
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        daoMenu.choiceDaoMenu(choice);
    }

    public void daoMenu() {
        System.out.println("Zarządzanie wydarzeniami.");
        System.out.println("1. Usuń wydarzenie");
        System.out.println("2. Dodaj wydarzenie");
        System.out.println("3. Edytuj wydarzenie");
        System.out.println("4. Wróć do głównego menu");
    }

    private void choiceDaoMenu(String choice) throws IOException {
        Scanner scanner = new Scanner(System.in);
        switch (choice) {
            case "1":
                System.out.println("Podaj ID wydarzenia, które chcesz usunąć:");
                break;
            case "2":
                System.out.println("Podaj dane:");
                break;
            case "3":
                System.out.println("Edytuj dane:");
                break;
            case "4":
                new MainMenu().mainMenu();
                break;
            default:
                System.out.println("Proszę podać cyfrę z zakresu menu");
        }
    }

}
