package com.isa.zajavieni.jsonclasses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("root_category")
    private CategoryType type;

    public Category() {
    }

    public Category(Long id, String name, CategoryType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

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