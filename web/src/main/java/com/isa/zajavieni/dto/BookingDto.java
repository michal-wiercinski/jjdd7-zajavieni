package com.isa.zajavieni.dto;

import java.util.Date;

public class BookingDto {

  Long bookingId;
  EventDto eventDto;
  UserDto userDto;

  public Long getBookingId() {
    return bookingId;
  }

  public void setBookingId(Long bookingId) {
    this.bookingId = bookingId;
  }

  public EventDto getEventDto() {
    return eventDto;
  }

  public void setEventDto(EventDto eventDto) {
    this.eventDto = eventDto;
  }

  public UserDto getUserDto() {
    return userDto;
  }

  public void setUserDto(UserDto userDto) {
    this.userDto = userDto;
  }

  /* Long eventId;
  String eventName;
  Date eventStartDate;
  Date eventEndDate;
  Long userId;
*/
 /* public Long getBookingId() {
    return bookingId;
  }

  public void setBookingId(Long bookingId) {
    this.bookingId = bookingId;
  }

  public Long getEventId() {
    return eventId;
  }

  public void setEventId(Long eventId) {
    this.eventId = eventId;
  }

  public String getEventName() {
    return eventName;
  }

  public void setEventName(String eventName) {
    this.eventName = eventName;
  }

  public Date getEventStartDate() {
    return eventStartDate;
  }

  public void setEventStartDate(Date eventStartDate) {
    this.eventStartDate = eventStartDate;
  }

  public Date getEventEndDate() {
    return eventEndDate;
  }

  public void setEventEndDate(Date eventEndDate) {
    this.eventEndDate = eventEndDate;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }*/
}
