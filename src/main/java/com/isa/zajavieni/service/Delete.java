package com.isa.zajavieni.service;

import com.isa.zajavieni.repository.EventList;

import java.io.IOException;
import java.util.Scanner;

public class Delete {

    public static void main(String[] args) throws IOException {

        PrinterEvents printerEvents = new PrinterEvents();
        printerEvents.printListOfEvents(EventList.getEventList());

        System.out.println("Podaj numer wydarzenia, ktore chcesz usunac: ");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println(i);
    }


}
