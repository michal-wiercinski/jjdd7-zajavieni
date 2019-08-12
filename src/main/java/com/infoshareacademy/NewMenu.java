package com.infoshareacademy;

import java.io.IOException;
import java.util.Scanner;


public class NewMenu {

    public static class Main {

        public static String menu(){
            System.out.println();
            System.out.println("     ****************************************");
            System.out.println("     *                 MENU                 *");
            System.out.println("     ****************************************");
            System.out.println("     1. Lista wszystkich wydarzeń");
            System.out.println("     2. Wyszukaj wydarzenie: ");
            System.out.println("     3. Twoje ulubione wydarzenia: ");
            System.out.println("     0. Koniec");

            Scanner in = new Scanner(System.in);
            String w = in.next();

            return w;
        }

        public static void main(String[] args) throws IOException {
            EventMenu eventMenu = new EventMenu();
            Scanner in = new Scanner(System.in);
            String choice = menu();

            while(!choice.equals("0")){
                switch(choice){
                    case "1":
                        System.out.println("Tu będzie lista wszystkich wydarzeń");
                        break;
                    case "2":
                        System.out.println("1. Podaj nazwę wydarzenia: (min. 3 litery)");
                        System.out.println("2. Wyszukaj po dacie: (DD.MM.YYYY)");
                        System.out.println("3. Wyszukaj po organizatorze: ");
                        System.out.println("Prosze podac cyfre z zakresu submenu ");

                        String nextMenuChoice;
                        nextMenuChoice= in.next();
                        eventMenu.printMenu(nextMenuChoice);
                        break;
                    case "3":
                        System.out.println("Tu będzie lista Twoich ulubionych wydarzeń");
                        break;
                }

                System.out.println("\nWciśnij Enter, aby kontynuować...");
                System.in.read();

                //System.out.print("\033[H\033[2J");
                //System.out.flush();

                choice = menu();
            }


            System.out.println("     ****************************************");
            System.out.println("\n     Koniec programu\n\n");
        }
    }
}
