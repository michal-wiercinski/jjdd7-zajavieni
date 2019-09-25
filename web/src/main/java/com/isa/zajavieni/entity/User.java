package com.isa.zajavieni.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
    @NamedQuery(
        name = "User.findAll",
        query = "SELECT u FROM User u"
    ),
    @NamedQuery(
        name = "User.findByEmail",
        query = "SELECT u FROM User u WHERE u.email = :email"
    ),
    @NamedQuery(
        name = "User.findWithFavouriteEvents",
        query = "select u from User u inner join u.events e where e.id = :id"
    )
})
@Entity
@Table(name = "user", indexes = {@Index(name = "user_email", columnList = "email")})
public class User {

  @Id
  @Column(name = "user_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(name = "user_type")
  UserType userType;

  @Column(name = "user_name")
  String name;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "user_event",
      joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "id_event", referencedColumnName = "event_id"))
  List<Event> events = new ArrayList<>();


  @Column(name = "email")
  String email;

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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}