package com.isa.zajavieni.service;

import com.isa.zajavieni.jsonclasses.Category;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class CategoriesDao {

    private DataParseService dataParseService = new DataParseService();

    public List<Category> getCategories() throws IOException {
        return dataParseService.parseCategories("categories.json");
    }

    public Optional<Category> getCategoryById(Long id) throws IOException {
        for (Category category : getCategories()) {
            if (category.getId().equals(id)) {
                return Optional.of(category);
            }
        }
        return Optional.empty();
    }
}
