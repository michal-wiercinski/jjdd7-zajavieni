package com.isa.zajavieni.repository;

import com.isa.zajavieni.jsonclasses.Address;

import java.util.Scanner;

public class AddressChooser {

    public Address addressChoose(){
        Address address = new Address();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adres");
        System.out.println("Podaj miasto");
        address.setCity(scanner.nextLine());
        System.out.println("Podaj ulice");
        address.setStreet(scanner.nextLine());

        return address;
    }

}
