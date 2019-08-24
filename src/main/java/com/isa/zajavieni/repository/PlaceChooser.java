package com.isa.zajavieni.repository;

import com.isa.zajavieni.jsonclasses.Address;
import com.isa.zajavieni.jsonclasses.Place;

import java.util.Scanner;

public class PlaceChooser {

    public Place placeChoose(){
        Place place = new Place();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Miejsce");
        System.out.println("Podaj id");
        place.setPlaceId(scanner.nextLong());
        AddressChooser addressChooser = new AddressChooser();
        place.setAddress(addressChooser.addressChoose());

        System.out.println("Podaj nazwe miejsca");
        place.setName(scanner.nextLine());
        System.out.println("Podaj dokładne miejsce");
        place.setSubname(scanner.nextLine());
        scanner.close();

        return place;
    }

}
