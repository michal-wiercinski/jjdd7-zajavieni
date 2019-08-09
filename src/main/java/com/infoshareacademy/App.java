package com.infoshareacademy;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {

        System.out.println("Zajavieni");

        Deserialization deserialization = new Deserialization();
        System.out.println(deserialization.deserializeCategories("categories.json"));
        System.out.println(deserialization.deserializePlaces("places.json"));
        System.out.println(deserialization.deserializeOrganizers("organizers.json"));
        System.out.println(deserialization.deserializeEvents("events.json"));

    }
}
