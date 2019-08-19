package com.isa.zajavieni.jsonclasses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Place {
    @JsonProperty("id")
    private Long placeId;
    @JsonProperty("address")
    private Address address;
    @JsonProperty("name")
    private String name;
    @JsonProperty("subname")
    private String subname;

    public Long getPlaceId() {
        return placeId;
    }

    public Address getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getSubname() {
        return subname;
    }

    @Override
    public String toString() {
        return "Place{" +
                "placeID=" + placeId +
                ", adress=" + address +
                ", name='" + name + '\'' +
                ", subname='" + subname + '\'' +
                '}';
    }
}