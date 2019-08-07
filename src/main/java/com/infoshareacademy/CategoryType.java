package com.infoshareacademy;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryType {
    @JsonProperty("id")
    private Long categoryTypeID;
    @JsonProperty("name")
    private String name;

    public CategoryType(Long categoryTypeID, String name) {
        this.categoryTypeID = categoryTypeID;
        this.name = name;
    }

    public Long getCategoryTypeID() {
        return categoryTypeID;
    }

    public void setCategoryTypeID(Long categoryTypeID) {
        this.categoryTypeID = categoryTypeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoryType{" +
                "categoryTypeID=" + categoryTypeID +
                ", name='" + name + '\'' +
                '}';
    }
}
