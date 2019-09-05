package com.isa.zajavieni.Entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category_type")
public class CategoryType {

  @Id
  @Column(name = "category_type_id")
  Long id;

  @Column(name = "name")
  String name;

  @OneToMany(mappedBy = "categoryType")
  List<Category> categories = new ArrayList<>();

  public CategoryType(String name) {
    this.name = name;
  }

  public CategoryType() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Category> getCategories() {
    return categories;
  }

  public void setCategories(List<Category> categories) {
    this.categories = categories;
  }
}
