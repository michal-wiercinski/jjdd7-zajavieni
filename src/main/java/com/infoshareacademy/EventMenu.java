package com.infoshareacademy;

public class EventMenu {
    public void printMenu(String nextMenuChoice){
        System.out.println("1. Podaj nazwę wydarzenia: (min. 3 litery)");
        System.out.println("2. Wyszukaj po dacie: (DD.MM.YYYY");
        System.out.println("3. Wyszukaj po organizatorze: ");

        switch (nextMenuChoice) {
            case "1":
                System.out.println("1. To będzie działać");
                break;
            case "2":
                System.out.println("2. To będzie działać");
                break;
            case "3":
                System.out.println("3. To będzie działać");
            default:
                System.out.println("Prosze podac cyfre z zakresu submenu lub wróć do poprzedniego ekranu");
        }
    }
}
