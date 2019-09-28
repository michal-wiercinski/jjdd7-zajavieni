package com.isa.zajavieni.dto;

import com.isa.zajavieni.entity.Event;
import com.isa.zajavieni.entity.User;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

}
