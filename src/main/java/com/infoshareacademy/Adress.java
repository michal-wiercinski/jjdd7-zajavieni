package com.infoshareacademy;

public class Adress {
    private String street;
    private String zipcode;
    private String city;
    private String latitude;
    private String longitude;

    public Adress(String street, String zipcode, String city, String latitude, String longitude) {
        this.street = street;
        this.zipcode = zipcode;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
