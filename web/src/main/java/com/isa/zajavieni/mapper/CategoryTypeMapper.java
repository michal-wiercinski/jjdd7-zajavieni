package com.isa.zajavieni.mapper;

import com.isa.zajavieni.entity.CategoryType;
import com.isa.zajavieni.servlet.LoggerServlet;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class CategoryTypeMapper {

  private Logger logger = LoggerFactory.getLogger(LoggerServlet.class.getName());

  public CategoryType mapCategoryTypeToEntity(
      com.isa.zajavieni.jsonclasses.CategoryType apiCategoryType) {
    logger.info("Map categoryTypeApi to entity");
    if (apiCategoryType == null) {
      return null;
    }
    CategoryType categoryType = new CategoryType();
    categoryType.setId(apiCategoryType.getId());
    categoryType.setName(apiCategoryType.getName());
    return categoryType;
  }
}
