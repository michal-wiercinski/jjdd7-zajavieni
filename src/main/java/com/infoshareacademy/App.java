package com.infoshareacademy;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        System.out.println("Zajavieni");

        DomainDeserializer domainDeserializer = new DomainDeserializer();
        System.out.println(domainDeserializer.deserializeCategories("categories.json"));
        System.out.println(domainDeserializer.deserializePlaces("places.json"));
        System.out.println(domainDeserializer.deserializeOrganizers("organizers.json"));
        System.out.println(domainDeserializer.deserializeEvents("events.json"));
    }
}