package com.isa.zajavieni.mapper.entityMapper;

import com.isa.zajavieni.entity.Category;
import com.isa.zajavieni.web.servlet.LoggerServlet;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class CategoryMapper {

  @EJB
  private CategoryTypeMapper categoryTypeMapper;

  private Logger logger = LoggerFactory.getLogger(LoggerServlet.class.getName());

  public Category mapCategoriesApiToEntity(com.isa.zajavieni.jsonclasses.Category categoryApi) {
    logger.info("Map categoriesApi id: {} to entity", categoryApi.getId());
    Category category = new Category();
    category.setId(categoryApi.getId());
    category.setName(categoryApi.getName());
    category.setCategoryType(categoryTypeMapper.mapCategoryTypeToEntity(categoryApi.getType()));
    return category;
  }
}
