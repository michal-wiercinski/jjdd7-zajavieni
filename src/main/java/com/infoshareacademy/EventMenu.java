package com.infoshareacademy;

public class EventMenu {

    public void printMenu(String nextMenuChoice){

        switch (nextMenuChoice) {
            case "1":
                System.out.println("1. To będzie działać");
                break;
            case "2":
                System.out.println("2. To będzie działać");
                break;
            case "3":
                System.out.println("3. To będzie działać");
                break;
            case "4":
                System.out.println("4. Naciśnij 4 żeby wrócić do poprzedniego menu");
                break;
            default:
                System.out.println("Prosze podac cyfre z zakresu submenu");
        }
    }
}
