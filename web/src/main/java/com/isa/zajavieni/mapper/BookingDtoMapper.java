package com.isa.zajavieni.mapper;

import com.isa.zajavieni.dto.BookingDto;
import com.isa.zajavieni.entity.Booking;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class BookingDtoMapper {

  @EJB
  EventDtoMapper eventDtoMapper;

  @EJB
  UserDtoMapper userDtoMapper;
  public BookingDto mapEntityToDto(Booking booking){
    BookingDto bookingDto = new BookingDto();

    bookingDto.setBookingId(booking.getBookingId());
    bookingDto.setEventId(eventDtoMapper.mapEventToDto(booking.getEvent()).getId());
    bookingDto.setUserId(userDtoMapper.mapEntityToDto(booking.getUser()).getId());

    return bookingDto;
  }

}
