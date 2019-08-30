package com.isa.zajavieni.service;

import com.isa.zajavieni.jsonclasses.Category;
import com.isa.zajavieni.repository.CategoryList;

import java.util.Optional;

public class CategoriesDao {

    public Optional<Category> getCategoryById(Long id) {
        for (Category category : CategoryList.getCategoryList()) {
            if (category.getId().equals(id)) {
                return Optional.of(category);
            }
        }
        return Optional.empty();
    }
}
