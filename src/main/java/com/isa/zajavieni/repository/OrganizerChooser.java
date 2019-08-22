package com.isa.zajavieni.repository;

import com.isa.zajavieni.jsonclasses.Organizer;

import java.util.Scanner;

public class OrganizerChooser {

    //wybierz organizatora z listy albo wprowadz dane

    public Organizer organizerChoose(){
        Organizer organizer = new Organizer();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Organizator");
        System.out.println("Podaj id organizatora");
        organizer.setId(scanner.nextLong());
        System.out.println("Podaj nazwę organizatora");
        organizer.setDesignation(scanner.nextLine());
        scanner.close();
        return organizer;
    }

}
