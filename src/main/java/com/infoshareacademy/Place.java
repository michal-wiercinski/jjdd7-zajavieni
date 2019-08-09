package com.infoshareacademy;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Place {

    @JsonProperty("id")
    private Long placeID;
    @JsonProperty("address")
    private Address address;
    @JsonProperty("name")
    private String name;
    @JsonProperty("subname")
    private String subname;

    public Long getPlaceID() {
        return placeID;
    }

    public void setPlaceID(Long placeID) {
        this.placeID = placeID;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }

    @Override
    public String toString() {
        return "Place{" +
                "placeID=" + placeID +
                ", adress=" + address +
                ", name='" + name + '\'' +
                ", subname='" + subname + '\'' +
                '}';
    }
}
