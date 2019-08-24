package com.isa.zajavieni.menu;

import com.isa.zajavieni.repository.EventList;
import com.isa.zajavieni.service.EventPrinter;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class MainMenu {
    BreadcrumbHistory bh = new BreadcrumbHistory();

    public void mainMenu() throws IOException, ParseException {
        printTextMainMenu();
        Scanner in = new Scanner(System.in);
        String choice = in.nextLine();
        choiceMenu(choice);

    }

    private void printTextMainMenu() {
        System.out.println(bh.toString());
        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *                 MENU                 *");
        System.out.println("     ****************************************");
        System.out.println("     1. Lista wszystkich wydarzeń");
        System.out.println("     2. Wyszukaj wydarzenie: ");
        System.out.println("     3. Twoje ulubione wydarzenia: ");
        System.out.println("     4. Zarządzaj wydarzeniami");
        System.out.println("     0. Koniec");
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
                System.out.println("Tu będzie lista Twoich ulubionych wydarzeń.");
                bh.addToHistory("Tu będzie lista Twoich ulubionych wydarzeń -> ");
                break;
            case "4":
                bh.addToHistory("Zarządzaj wydarzeniami");
                new EventMenuHandler().printEventMenu();
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