package com.infoshareacademy;

import java.io.IOException;
import java.util.Scanner;


public class NewMenu {

    public static class Menu {

        public String mainMenu() throws IOException {
            System.out.println();
            System.out.println("     ****************************************");
            System.out.println("     *                 MENU                 *");
            System.out.println("     ****************************************");
            System.out.println("     1. Lista wszystkich wydarzeń");
            System.out.println("     2. Wyszukaj wydarzenie: ");
            System.out.println("     3. Twoje ulubione wydarzenia: ");
            System.out.println("     0. Koniec");
            Scanner in = new Scanner(System.in);
            String choice = in.next();
            choiceMenu(choice);
            System.out.println("     ****************************************");
            System.out.println("\n     Koniec programu\n\n");
            return choice;
        }

        private void choiceMenu(String choice) throws IOException {
            Scanner in = new Scanner(System.in);
            while (!choice.equals("0")) {
                switch (choice) {
                    case "1":
                        EventService eventService = new EventService();
                        eventService.printListOfEvents();
                        break;
                    case "2":
                        System.out.println("Tu będziesz mógł wyszukać wydarzenie.");
                        break;
                    case "3":
                        System.out.println("Tu będzie lista Twoich ulubionych wydarzeń.");
                        break;
                    default:
                        System.out.println("Wpisałeś coś niewłaściwego, wybierz liczbę z zakresu menu.");
                }
                System.out.println("\nWciśnij Enter, aby kontynuować...");
                System.in.read();
                choice = mainMenu();
            }
        }
    }
}