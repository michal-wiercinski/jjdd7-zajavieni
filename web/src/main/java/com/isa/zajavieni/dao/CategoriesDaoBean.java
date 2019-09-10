package com.isa.zajavieni.dao;

import com.isa.zajavieni.Entity.Category;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CategoriesDaoBean {

  @PersistenceContext
  EntityManager entityManager;

  public void saveCategory(Category category) {
    entityManager.persist(category);
  }

  public void editCategory(Category category) {
    entityManager.merge(category);
  }

  public Category findCategoryById(Long id) {
    return entityManager.find(Category.class, id);
  }
}
