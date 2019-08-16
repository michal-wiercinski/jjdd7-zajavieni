package com.infoshareacademy;

import java.io.IOException;
import java.util.Scanner;


public class NewMenu {

    public static class Menu {
        //MenuBreadcrumbs menuBreadcrumbs = new MenuBreadcrumbs();
        BreadcrumbHistory bh = new BreadcrumbHistory();

        public String mainMenu() throws IOException {
            //System.out.println(menuBreadcrumbs.breadcrumbs);
            System.out.println(bh.toString());
            System.out.println();
            System.out.println("     ****************************************");
            System.out.println("     *                 MENU                 *");
            System.out.println("     ****************************************");
            System.out.println("     1. Lista wszystkich wydarzeń");
            System.out.println("     2. Wyszukaj wydarzenie ");
            System.out.println("     3. Twoje ulubione wydarzenia ");
            System.out.println("     0. Koniec");
            Scanner in = new Scanner(System.in);
            String choice = in.next();
            choiceMenu(choice);
            return choice;
        }

        private void choiceMenu(String choice) throws IOException {
            Scanner in = new Scanner(System.in);
            switch (choice) {
                case "1":
                    EventService eventService = new EventService();
                    eventService.printListOfEvents();
                    //menuBreadcrumbs.breadcrumbs += "1. Lista wszystkich wydarzeń -> ";
                    bh.addToHistory("1. Lista wszystkich wydarzeń -> ");
                    comebackToChoice(choice);
                    break;
                case "2":
                    System.out.println("Tu będziesz mógł wyszukać wydarzenie.");
                    //menuBreadcrumbs.breadcrumbs += "2. Wyszukaj wydarzenie -> ";
                    comebackToChoice(choice);
                    break;
                case "3":
                    System.out.println("Tu będzie lista Twoich ulubionych wydarzeń.");
                    //menuBreadcrumbs.breadcrumbs += "3. Twoje ulubione wydarzenia -> ";
                    comebackToChoice(choice);
                    break;
                case "0":
                    System.out.println("     ****************************************");
                    System.out.println("\n     Koniec programu\n\n");
                    break;
                default:
                    System.out.println("Wpisałeś coś niewłaściwego, wybierz liczbę z zakresu menu.");
                    comebackToChoice(choice);
            }
        }

        private void comebackToChoice(String choice) throws IOException {
            System.out.println("Czy chcesz kontynuować? T / N");
            Scanner scanner = new Scanner(System.in);
            String yesOrNot = scanner.nextLine();
            MenuBreadcrumbs menuBreadcrumbs = new MenuBreadcrumbs();
            if (yesOrNot.equalsIgnoreCase("n")) {
                menuBreadcrumbs.breadcrumbs = "";
                choiceMenu("0");
            } else if (yesOrNot.equalsIgnoreCase("t")) {
                bh.removeLast();
                //menuBreadcrumbs.breadcrumbs = "";
                mainMenu();
            }
        }
    }
}