package com.isa.zajavieni.mapper;

import com.isa.zajavieni.entity.CategoryType;
import javax.ejb.Stateless;

@Stateless
public class CategoryTypeMapper {

  public CategoryType mapCategoryTypeToEntity(
      com.isa.zajavieni.jsonclasses.CategoryType apiCategoryType) {
    if (apiCategoryType == null) {
      return null;
    }
    CategoryType categoryType = new CategoryType();
    categoryType.setId(apiCategoryType.getId());
    categoryType.setName(apiCategoryType.getName());
    return categoryType;
  }
}
