package com.isa.zajavieni.mapper.entitymapper;

import com.isa.zajavieni.entity.fromapi.CategoryType;
import com.isa.zajavieni.web.servlet.LoggerServlet;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class CategoryTypeMapper {

  private Logger logger = LoggerFactory.getLogger(LoggerServlet.class.getName());

  public CategoryType mapCategoryTypeToEntity(
      com.isa.zajavieni.jsonclasses.CategoryType apiCategoryType) {
    logger.info("Map categoryTypeApi id: {} to entity", apiCategoryType.getId());
    if (apiCategoryType == null) {
      return null;
    }
    CategoryType categoryType = new CategoryType();
    categoryType.setId(apiCategoryType.getId());
    categoryType.setName(apiCategoryType.getName());
    return categoryType;
  }
}
