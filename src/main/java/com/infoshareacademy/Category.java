package com.infoshareacademy;

public class Category {
    private Long categoryID;
    private String categoryName;
    private CategoryType categoryType;

    public Category(Long categoryID, String categoryName, CategoryType categoryType) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
