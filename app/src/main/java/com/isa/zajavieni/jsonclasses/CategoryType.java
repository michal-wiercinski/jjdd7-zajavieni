package com.isa.zajavieni.jsonclasses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryType {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "CategoryType{" +
                "categoryTypeID=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}