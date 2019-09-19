package com.isa.zajavieni.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

  @Id
  @Column(name = "user_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(name = "user_type")
  UserType userType;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "user_event",
      joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "id_event", referencedColumnName = "id"))
  List<Event> events = new ArrayList<>();

  public User(UserType userType) {
    this.userType = userType;
  }

  public User() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public UserType getUserType() {
    return userType;
  }

  public void setUserType(UserType userType) {
    this.userType = userType;
  }

  public List<Event> getEvents() {
    return events;
  }

  public void setEvents(List<Event> events) {
    this.events = events;
  }
}
