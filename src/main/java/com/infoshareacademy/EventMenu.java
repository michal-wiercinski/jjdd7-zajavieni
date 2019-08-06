package com.infoshareacademy;

public class EventMenu {
    public void printMenu(int menuChoice){
        System.out.println("1. Podaj nazwę wydarzenia: (min. 3 litery)");
        System.out.println("2. Wyszukaj po dacie: (DD.MM.YYYY");
        System.out.println("3. Wyszukaj po organizatorze: ");

        switch (menuChoice) {
            case 1:
                System.out.println("To będzie działać");
                break;
            case 2:
                System.out.println("To będzie działać");
                break;
            case 3:
                System.out.println("To będzie działać");
            default:
                System.out.println("Prosze podac cyfre z zakresu submenu lub wróć do poprzedniego ekranu");
        }
    }
}
