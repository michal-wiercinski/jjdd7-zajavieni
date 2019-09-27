package com.isa.zajavieni.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "booking")
public class Booking {

  @Id
  @Column(name = "id")
  Long bookingId;

  @ManyToOne
  @JoinColumn(name = "event_id")
  Event event;

  @ManyToOne
  @JoinColumn(name = "user_id")
  User user;

  public Long getBookingId() {
    return bookingId;
  }

  public void setBookingId(Long bookingId) {
    this.bookingId = bookingId;
  }

  public Event getEvent() {
    return event;
  }

  public void setEvent(Event event) {
    this.event = event;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}