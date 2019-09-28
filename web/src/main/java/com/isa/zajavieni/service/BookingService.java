package com.isa.zajavieni.service;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.isa.zajavieni.dao.BookingDaoBean;
import com.isa.zajavieni.dto.BookingDto;
import com.isa.zajavieni.dto.EventDto;
import com.isa.zajavieni.dto.UserDto;
import com.isa.zajavieni.entity.Booking;
import com.isa.zajavieni.entity.Event;
import com.isa.zajavieni.entity.User;
import com.isa.zajavieni.mapper.dtoMapper.BookingDtoMapper;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

@Stateless
public class BookingService {


  @EJB
  BookingDaoBean bookingDaoBean;
  @EJB
  UserService userService;

  @EJB
  BookingDtoMapper bookingDtoMapper;

  public void saveBooking(BookingDto booking) {
    bookingDaoBean.saveBooking(bookingDtoMapper.mapDtoToEntity(booking));
  }



  public void deleteBooking(BookingDto booking) {
    bookingDaoBean.removeBooking(bookingDtoMapper.mapDtoToEntity(booking));
  }

  @Transactional
  public List<com.isa.zajavieni.dto.BookingDto> findBookingsForUser(Long id) {
    UserDto user = userService.findUserDtoById(id);
    return user.getBookings();
  }

  @Transactional
  public BookingDto createBooking(EventDto event, UserDto user) {
    BookingDto booking = new BookingDto();
    booking.setUserDto(user);
    booking.setEventDto(event);
    return booking;
  }

}
