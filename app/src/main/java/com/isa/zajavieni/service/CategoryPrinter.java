package com.isa.zajavieni.service;

import com.isa.zajavieni.jsonclasses.Category;

import java.util.List;

public class CategoryPrinter {

    public void printCategories(List<Category> categories) {
        System.out.println("id kategoria");
        for (Category category : categories) {
            System.out.println(category.getId() + " " + category.getName());
        }
    }
}
