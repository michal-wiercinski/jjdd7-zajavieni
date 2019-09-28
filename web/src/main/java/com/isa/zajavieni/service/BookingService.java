package com.isa.zajavieni.service;

import com.isa.zajavieni.dao.BookingDaoBean;
import com.isa.zajavieni.dto.BookingDto;
import com.isa.zajavieni.dto.UserDto;
import com.isa.zajavieni.entity.Booking;
import com.isa.zajavieni.entity.Event;
import com.isa.zajavieni.entity.User;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class BookingService {


  @EJB
  BookingDaoBean bookingDaoBean;
  @EJB
  UserService userService;

  public void saveBooking(Booking booking){
    bookingDaoBean.saveBooking(booking);
  }

  public void deleteBooking(Booking booking){
    bookingDaoBean.removeBooking(booking);
  }

  public List<BookingDto> findBookingsForUser(Long id){
    UserDto user = userService.findUserDtoById(id);
    return user.getBookings();
  }

  public Booking createBooking(Event event, User user){
    Booking booking = new Booking();
    booking.setUser(user);
    booking.setEvent(event);
    return booking;
  }

}
