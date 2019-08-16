package com.isa.zajavieni.jsonclasses;

public class CategoryType {
    private Long id;
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