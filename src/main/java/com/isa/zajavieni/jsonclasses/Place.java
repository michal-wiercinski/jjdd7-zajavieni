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

    public Place() {
    }

    public Place(Long placeId, Address address, String name, String subname) {
        this.placeId = placeId;
        this.address = address;
        this.name = name;
        this.subname = subname;
    }

    public Place(Long placeId, Address address, String name) {
        this(placeId, address, name, null);
    }

    public String getName() {
        return name;
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