package com.infoshareacademy;

public class Category {
    private Long categoryID;
    private String name;
    private CategoryType type;

    public Category(Long categoryID, String name, CategoryType type) {
        this.categoryID = categoryID;
        this.name = name;
        this.type = type;
    }

    public Long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Long categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryType getType() {
        return type;
    }

    public void setType(CategoryType type) {
        this.type = type;
    }
}
