package com.isa.zajavieni.menu;

import com.isa.zajavieni.repository.EventList;
import com.isa.zajavieni.repository.FavouriteEventList;
import com.isa.zajavieni.service.ConfigurationLoader;
import com.isa.zajavieni.service.ConsoleCleaner;
import com.isa.zajavieni.service.EventPrinter;

import com.isa.zajavieni.service.FavouriteEventPrinter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Properties;
import java.util.Scanner;

public class MainMenu {
    BreadcrumbHistory bh = new BreadcrumbHistory();

    public void mainMenu() throws IOException, ParseException {
        printTextMainMenu();
        Scanner in = new Scanner(System.in);
        String choice = in.nextLine();
        choiceMenu(choice);
    }

    private void printTextMainMenu() throws IOException {
        ConsoleCleaner.cleanConsole();
        FavouriteEventPrinter favouriteEventPrinter = new FavouriteEventPrinter();
        favouriteEventPrinter.printFavouriteEvent(FavouriteEventList.getFavouriteEventList());
        System.out.println(bh.toString());
        System.out.println("\t****************************************");
        System.out.println("\t*                 MENU                 *");
        System.out.println("\t****************************************");
        System.out.println("\t1. Lista wszystkich wydarzeń");
        System.out.println("\t2. Wyszukaj wydarzenie ");
        System.out.println("\t3. Twoje ulubione wydarzenia ");
        System.out.println("\t4. Zarządzaj wydarzeniami");
        System.out.println("\t5. Ładowanie konfiguracji");
        System.out.println("\t0. Koniec");
    }

    private void choiceMenu(String choice) throws IOException, ParseException {
        switch (choice) {
            case "1":
                new EventPrinter().printListOfEvents(EventList.getEventList());
                bh.addToHistory("1. Lista wszystkich wydarzeń -> ");
                comebackToChoice(choice);
                break;
            case "2":
                new EventSearchingMenu().printSearchMenu();
                bh.addToHistory("2. Wyszukaj wydarzenie: -> ");
                break;
            case "3":
                new FavouriteEventMenu().printFavouriteMenu();
                bh.addToHistory("Zarządzaj ulubionymi wydarzeniami -> ");
                break;
            case "4":
                bh.addToHistory("Zarządzaj wydarzeniami");
                new EventMenuHandler().printEventMenu();
                mainMenu();
                break;
            case "5":
                bh.addToHistory("Ładowanie konfiguracji");
                ConfigurationLoader configurationLoader = new ConfigurationLoader();
                configurationLoader.getProperties();
                mainMenu();
                break;
            case "0":
                System.out.println("     ****************************************");
                System.out.println("\n     Koniec programu\n\n");
                break;
            default:
                System.out.println("Wpisałeś coś niewłaściwego, wybierz liczbę z zakresu menu.");
                mainMenu();
        }
    }

    private void comebackToChoice(String choice) throws IOException, ParseException {
        System.out.println("Czy chcesz kontynuować? T / N");
        Scanner scanner = new Scanner(System.in);
        String yesOrNot = scanner.nextLine();
        if (yesOrNot.equalsIgnoreCase("n")) {
            choiceMenu("0");
            scanner.close();
        } else if (yesOrNot.equalsIgnoreCase("t")) {
            bh.removeLast();
            mainMenu();
        }
    }
}