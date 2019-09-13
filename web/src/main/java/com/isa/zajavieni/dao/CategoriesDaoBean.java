package com.isa.zajavieni.dao;

import com.isa.zajavieni.entity.Category;
import com.isa.zajavieni.servlet.LoggerServlet;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class CategoriesDaoBean {

  private Logger logger = LoggerFactory.getLogger(LoggerServlet.class.getName());

  @PersistenceContext
  EntityManager entityManager;

  public void editCategory(Category category) {
    logger.info("Object category id: {} merge to DB", category.getId());
    entityManager.merge(category);
  }

  public Category findCategoryById(Long id) {
    logger.info("Object category id: {} find", id);
    return entityManager.find(Category.class, id);
  }
}
