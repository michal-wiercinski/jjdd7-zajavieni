package com.infoshareacademy;

public class Menu {
    EventMenu eventMenu = new EventMenu();
    String nextMenuChoice = ScannerForClasses.scan.nextLine();
    //Scanner scanner = new Scanner(System.in);
    //int subMenuChoice = scanner.nextInt();


    public void menu(int menuChoice){
        switch (menuChoice) {
            case 1:
                System.out.println("Tu będzie lista wszystkich wydarzeń");
                break;
            case 2:
                //wejscie do submenu
                eventMenu.printMenu(nextMenuChoice);
                ScannerForClasses.scan.close();
                break;
            case 3:
                System.out.println("Tu będą Twoje ulubione wydarzenia");
                break;
            default:
                System.out.println("Prosze podac cyfre z zakresu menu");
        }

    }
}
