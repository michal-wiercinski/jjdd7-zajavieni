package com.infoshareacademy;

public class Menu {
    EventMenu eventMenu = new EventMenu();
    //ScannerForClasses scannerForClasses = new ScannerForClasses();
    //String nextMenuChoice = ScannerForClasses.scan.nextLine();
    //Scanner scanner = new Scanner(System.in);
    //int subMenuChoice = scanner.nextInt();


    public void menu(int menuChoice){
        switch (menuChoice) {
            //ScannerForClasses scannerForClasses = new ScannerForClasses();
           // String nextMenuChoice = ScannerForClasses.scan.nextLine();

            case 1:
                System.out.println("Tu będzie lista wszystkich wydarzeń");
                break;
            case 2:
                //wejscie do submenu
                System.out.println("1. Podaj nazwę wydarzenia: (min. 3 litery)");
                System.out.println("2. Wyszukaj po dacie: (DD.MM.YYYY)");
                System.out.println("3. Wyszukaj po organizatorze: ");
                System.out.println("4. Prosze podac cyfre z zakresu menu ");
                String nextMenuChoice = ScannerForClasses.scan.nextLine();
                eventMenu.printMenu(nextMenuChoice);
                //ScannerForClasses.scan.close();
                break;
            case 3:
                System.out.println("Tu będą Twoje ulubione wydarzenia");
                break;
            default:
                System.out.println("Prosze podac cyfre z zakresu menu");
        }

    }
}
