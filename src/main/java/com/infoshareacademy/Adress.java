package com.infoshareacademy;

public class Adress {
    private String street;
    private String zipcode;
    private String city;
    private String latitiude;
    private String longitude;

    public Adress(String street, String zipcode, String city, String latitiude, String longitude) {
        this.street = street;
        this.zipcode = zipcode;
        this.city = city;
        this.latitiude = latitiude;
        this.longitude = longitude;
    }
}
