package com.isa.zajavieni.entity.createdentity;

import com.isa.zajavieni.entity.fromapi.Event;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
    @NamedQuery(
        name = "Booking.findBookingByUserId",
        query = "SELECT b FROM Booking b WHERE b.user.id IN :id"
    ),
    @NamedQuery(
        name = "Booking.findByEventAndUser",
        query = "SELECT b FROM Booking b WHERE b.event.id = :event_id AND b.user.id = :user_id"
    ),
    @NamedQuery(
        name = "Booking.findUserIdForBookedEvent",
        query = "SELECT b.user.id FROM Booking b WHERE b.event.id = :event_id"
    )
})
@Entity
@Table(name = "booking")
public class Booking {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long bookingId;

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
      CascadeType.REFRESH, CascadeType.DETACH})
  @JoinColumn(name = "event_id")
  Event event;

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
      CascadeType.REFRESH, CascadeType.DETACH})
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