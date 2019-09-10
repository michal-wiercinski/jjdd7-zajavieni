package com.isa.zajavieni.mapper;

import com.isa.zajavieni.Entity.Category;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class CategoryMapper {

  @EJB
  private CategoryTypeMapper categoryTypeMapper;

  public Category mapCategoriesApiToEntity(com.isa.zajavieni.jsonclasses.Category categoryApi) {
/*
    CategoryType categoryType = null;
    if(categoryApi.getType() != null) {
      categoryType = new CategoryType();
      categoryType.setId(categoryApi.getType().getId());
      categoryType.setName(categoryApi.getType().getName());
    }

 */

    Category category = new Category();
    category.setId(categoryApi.getId());
    category.setName(categoryApi.getName());
    category.setCategoryType(categoryTypeMapper.mapCategoryTypeToEntity(categoryApi.getType()));
    //if(categoryType != null) {
    //  categoryType.getCategories().add(category);
    //}
    //category.setCategoryType(categoryType);

    return category;
  }
}
