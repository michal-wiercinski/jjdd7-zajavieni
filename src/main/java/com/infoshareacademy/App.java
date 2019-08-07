package com.infoshareacademy;

public class App {

    public static void main(String[] args) {

        System.out.println("Zajavieni");

        JsonToObject convertAddress = new JsonToObject();

        convertAddress.convertToObject("/home/mich/DB/place.json", Address.class);


    }
}
