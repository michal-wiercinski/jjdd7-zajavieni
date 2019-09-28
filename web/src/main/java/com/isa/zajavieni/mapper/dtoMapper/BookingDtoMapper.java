package com.isa.zajavieni.mapper.dtoMapper;

import com.isa.zajavieni.dto.BookingDto;
import com.isa.zajavieni.entity.Booking;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

@Stateless
public class BookingDtoMapper {

  @EJB
  EventDtoMapper eventDtoMapper;

  @EJB
  UserDtoMapper userDtoMapper;

  @Transactional
  public BookingDto mapEntityToDto(Booking booking){
    BookingDto bookingDto = new BookingDto();

    bookingDto.setBookingId(booking.getBookingId());
    bookingDto.setEventDto(eventDtoMapper.mapEventToDto(booking.getEvent()));
    bookingDto.setUserDto(userDtoMapper.mapEntityToDto(booking.getUser()));

    return bookingDto;
  }
  @Transactional
  public Booking mapDtoToEntity(BookingDto bookingDto){
    Booking booking = new Booking();

    booking.setBookingId(booking.getBookingId());
    booking.setEvent(eventDtoMapper.mapDtoToEntity(bookingDto.getEventDto()));
    booking.setUser(userDtoMapper.mapDtoToEntity(bookingDto.getUserDto()));

    return booking;
  }





}
