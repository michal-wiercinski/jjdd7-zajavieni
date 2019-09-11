package com.isa.zajavieni.dao;

import com.isa.zajavieni.entity.Category;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CategoriesDaoBean {

  @PersistenceContext
  EntityManager entityManager;

  public void editCategory(Category category) {
    entityManager.merge(category);
  }

  public Category findCategoryById(Long id) {
    return entityManager.find(Category.class, id);
  }
}
