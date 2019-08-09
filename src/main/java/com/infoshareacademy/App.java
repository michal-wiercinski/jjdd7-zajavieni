package com.infoshareacademy;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {

        System.out.println("Zajavieni");

        Deserialization deserialization = new Deserialization();
        System.out.println(deserialization.categoriesDeserialize("categories.json"));
        System.out.println(deserialization.placesDeserialize("places.json"));
        System.out.println(deserialization.organizersDeserialize("organizers.json"));
        System.out.println(deserialization.eventsDeserialize("events.json"));

    }
}
