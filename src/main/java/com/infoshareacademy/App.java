package com.infoshareacademy;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        /*BreadcrumbHistory bh = new BreadcrumbHistory();
        bh.addToHistory("dzien ");
        bh.addToHistory("dobry");
        bh.addToHistory("krolewno ");
        System.out.println(bh.toString());
        bh.removeLast();
        bh.removeLast();
        System.out.println(bh.toString());
        */

        new NewMenu.Menu().mainMenu();
    }
}