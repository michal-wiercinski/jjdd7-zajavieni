package com.isa.zajavieni.mapper;

import com.isa.zajavieni.entity.Category;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class CategoryMapper {

  @EJB
  private CategoryTypeMapper categoryTypeMapper;

  public Category mapCategoriesApiToEntity(com.isa.zajavieni.jsonclasses.Category categoryApi) {
    Category category = new Category();
    category.setId(categoryApi.getId());
    category.setName(categoryApi.getName());
    category.setCategoryType(categoryTypeMapper.mapCategoryTypeToEntity(categoryApi.getType()));
    return category;
  }
}
