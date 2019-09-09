package com.isa.zajavieni.mapper;

import com.isa.zajavieni.Entity.Category;
import com.isa.zajavieni.Entity.CategoryType;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class CategoriesMapper {

  public List<Category> mapCategoriesApiToEntity(List<com.isa.zajavieni.jsonclasses.Category> categoriesApiList) {
    List<Category> categories = new ArrayList<>();

    categoriesApiList.forEach(categoriesApi -> {
      CategoryType categoryType = new CategoryType();
      categoryType.setId(categoriesApi.getType().getId());
      categoryType.setName(categoriesApi.getType().getName());

      Category category = new Category();
      category.setId(categoriesApi.getId());
      category.setName(categoriesApi.getName());
      category.setCategoryType(categoryType);
      categories.add(category);
    });
    return categories;
  }
}
