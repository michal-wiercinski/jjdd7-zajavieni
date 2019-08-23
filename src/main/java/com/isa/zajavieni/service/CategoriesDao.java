package com.isa.zajavieni.service;

import com.isa.zajavieni.jsonclasses.Category;
import com.isa.zajavieni.jsonclasses.Organizer;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class CategoriesDao {

    private DataParseService dataParseService =new DataParseService();

    public List<Category> getCategories () throws IOException {
        return dataParseService.parseCategories("categories.json");
    }
    public Optional<Category> getCategoryById(Long id) throws IOException {
        for (Category category:getCategories()){

        }
    }



//    private DataParseService dataParseService = new DataParseService();
//
//    public List<Organizer> getOrganizers() throws IOException {
//        return dataParseService.parseOrganizers("organizers.json");
//    }
//
//    public Optional<Organizer> getOrganizerById(Long id) throws IOException {
//        for (Organizer organizer : getOrganizers()) {
//            if (organizer.getId().equals(id)) {
//                return Optional.of(organizer);
//            }
//        }
//        return Optional.empty();
//    }
}
