package com.isa.zajavieni.jsonclasses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category {
    private Long id;
    private String name;

    @JsonProperty("root_category")
    private CategoryType type;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CategoryType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryID=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}