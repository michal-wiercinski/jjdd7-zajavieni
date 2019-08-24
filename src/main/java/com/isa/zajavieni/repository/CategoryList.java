package com.isa.zajavieni.repository;

import com.isa.zajavieni.jsonclasses.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryList  {
    private static List<Category> categoruList = new ArrayList<>();
    private static final String CATEGORIES_JSON = "categories.json";

    private CategoryList() {
    }

    public static List<Category> getCategoruList() {
        return categoruList;
    }

    public static String getCategoriesJson() {
        return CATEGORIES_JSON;
    }
}
