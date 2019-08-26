package com.isa.zajavieni.service;

import com.isa.zajavieni.jsonclasses.Category;
import com.isa.zajavieni.jsonclasses.Place;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

class CategoriesDaoTest {

    @Test
    void getCategoryById_testIfReturnCategoryIsNotNull() throws IOException {
        CategoriesDao categoriesDaoes = new CategoriesDao();
        Long id = 207L;

        Optional<Category> expectedCategory = categoriesDaoes.getCategoryById(id);

        assertNotNull(expectedCategory);
    }

    @Test
    void getCategoryById_testIfReturnCategoryIsEmpty() throws IOException {
        CategoriesDao categoriesDaoes = new CategoriesDao();
        Long id = 33333L;

        Optional<Category> expectedCategory = categoriesDaoes.getCategoryById(id);

        assertThat(expectedCategory).isEqualTo(Optional.empty());
    }

}