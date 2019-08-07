package com.infoshareacademy;

public class CategoryType {
    private Long categoryTypeID;
    private String categoryTypeName;

    public CategoryType(Long categoryTypeID, String categoryTypeName) {
        this.categoryTypeID = categoryTypeID;
        this.categoryTypeName = categoryTypeName;
    }

    public Long getCategoryTypeID() {
        return categoryTypeID;
    }

    public void setCategoryTypeID(Long categoryTypeID) {
        this.categoryTypeID = categoryTypeID;
    }

    public String getCategoryTypeName() {
        return categoryTypeName;
    }

    public void setCategoryTypeName(String categoryTypeName) {
        this.categoryTypeName = categoryTypeName;
    }
}
