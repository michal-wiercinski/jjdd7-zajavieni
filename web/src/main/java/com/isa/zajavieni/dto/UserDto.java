package com.isa.zajavieni.dto;

import com.isa.zajavieni.entity.UserType;
import java.util.ArrayList;
import java.util.List;

public class UserDto {

  private Long id;

  private UserType userType;

  private String name;

  private List<EventDto> events = new ArrayList<>();

  private String email;

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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<EventDto> getEvents() {
    return events;
  }

  public void setEvents(List<EventDto> events) {
    this.events = events;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
