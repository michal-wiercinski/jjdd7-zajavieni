package com.isa.zajavieni.repository;

import com.isa.zajavieni.jsonclasses.Category;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;

class CategoryListTest {

    @Test
    void getCategoryList_testIfListIsNull() {
        List<Category> list = CategoryList.getCategoryList();

        assertNotNull(list);
    }
}