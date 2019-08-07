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

    public Long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Long categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }
}
