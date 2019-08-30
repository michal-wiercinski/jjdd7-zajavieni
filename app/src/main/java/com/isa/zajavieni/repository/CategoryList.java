package com.isa.zajavieni.repository;

import com.isa.zajavieni.jsonclasses.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryList  {
    private static List<Category> categoryList = new ArrayList<>();
    private static final String CATEGORIES_JSON = "categories.json";

    private CategoryList() {
    }

    public static List<Category> getCategoryList() {
        return categoryList;
    }

    public static String getCategoriesJson() {
        return CATEGORIES_JSON;
    }
}
