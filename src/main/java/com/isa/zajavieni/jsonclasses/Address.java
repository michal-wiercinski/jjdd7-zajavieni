package com.isa.zajavieni.jsonclasses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
    @JsonProperty("street")
    private String street;

    @JsonProperty("zipcode")
    private String zipcode;

    @JsonProperty("city")
    private String city;

    @JsonProperty("lat")
    private String latitude;

    @JsonProperty("lng")
    private String longitude;

    public String getStreet() {
        return street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "street='" + street + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", city='" + city + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
