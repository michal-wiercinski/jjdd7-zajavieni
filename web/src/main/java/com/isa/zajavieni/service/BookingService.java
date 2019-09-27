package com.isa.zajavieni.service;

import com.isa.zajavieni.dao.BookingDaoBean;
import com.isa.zajavieni.entity.Booking;
import com.isa.zajavieni.entity.Event;
import com.isa.zajavieni.entity.User;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class BookingService {


  @EJB
  BookingDaoBean bookingDaoBean;

  public void saveBooking(Booking booking){
    bookingDaoBean.saveBooking(booking);
  }

  public void deleteBooking(Booking booking){
    bookingDaoBean.removeBooking(booking);
  }

  public Booking createBooking(Event event, User user){
    Booking booking = new Booking();
    booking.setUser(user);
    booking.setEvent(event);
    return booking;
  }

}
