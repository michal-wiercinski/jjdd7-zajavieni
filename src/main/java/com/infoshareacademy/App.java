package com.infoshareacademy;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {

        System.out.println("Zajavieni");

        DomainDeserialization domainDeserialization = new DomainDeserialization();
        System.out.println(domainDeserialization.deserializeCategories("categories.json"));
        System.out.println(domainDeserialization.deserializePlaces("places.json"));
        System.out.println(domainDeserialization.deserializeOrganizers("organizers.json"));
        System.out.println(domainDeserialization.deserializeEvents("events.json"));

    }
}
