package com.infoshareacademy;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        System.out.println("Zajavieni");
        Deserializer deserializer = new Deserializer();
        System.out.println(deserializer.deserializeCategories("categories.json"));
        System.out.println(deserializer.deserializePlaces("places.json"));
        System.out.println(deserializer.deserializeOrganizers("organizers.json"));
        System.out.println(deserializer.deserializeEvents("events.json"));
    }
}
