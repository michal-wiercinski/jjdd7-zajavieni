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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
