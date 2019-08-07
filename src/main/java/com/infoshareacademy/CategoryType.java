package com.infoshareacademy;

public class CategoryType {
    private Long categoryTypeID;
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
}
