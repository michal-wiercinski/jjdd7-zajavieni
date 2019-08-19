package com.isa.zajavieni.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isa.zajavieni.jsonclasses.Category;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataParseServiceTest {


    @Test
    void testParseCategories() throws IOException {
        DataParseService parseCategories = new DataParseService();
        List<Category> list = parseCategories.parseCategories("categories.json");
        assertNotNull(list);
}

    @Test
    void testParsePlaces() {
    }

    @Test
    void testParseOrganizers() {
    }

    @Test
    void testParseEvents() {
    }
}