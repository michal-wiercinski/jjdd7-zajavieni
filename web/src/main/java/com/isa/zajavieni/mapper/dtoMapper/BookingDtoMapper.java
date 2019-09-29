package com.isa.zajavieni.mapper.dtoMapper;

import com.isa.zajavieni.dto.BookingDto;
import com.isa.zajavieni.entity.Booking;
import com.isa.zajavieni.entity.Event;
import com.isa.zajavieni.service.EventService;
import com.isa.zajavieni.service.UserService;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

@Stateless
public class BookingDtoMapper {

  @EJB
  EventDtoMapper eventDtoMapper;

  @EJB
  UserDtoMapper userDtoMapper;

  @EJB
  UserService userService;

  @EJB
  EventService eventService;

  @Transactional
  public BookingDto mapEntityToDto(Booking booking){
    BookingDto bookingDto = new BookingDto();

    bookingDto.setBookingId(booking.getBookingId());
    return bookingDto;
/*    bookingDto.setUserDto(userDtoMapper.mapEntityToDto(booking.getUser()));
    bookingDto.setEventDto(eventDtoMapper.mapEventToDto(booking.getEvent()));*/
  }
  @Transactional
  public Booking mapDtoToEntity(BookingDto bookingDto){
    Booking booking = new Booking();

    booking.setBookingId(booking.getBookingId());
    booking.setEvent(eventService.findEventById(bookingDto.getEventDto().getId()));
    booking.setUser(userService.findUserById(bookingDto.getUserDto().getId()));

    return booking;
  }





}
