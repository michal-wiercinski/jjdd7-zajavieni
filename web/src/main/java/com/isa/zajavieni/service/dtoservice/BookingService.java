package com.isa.zajavieni.service.dtoservice;

import com.isa.zajavieni.dao.BookingDaoBean;
import com.isa.zajavieni.dto.BookingDto;
import com.isa.zajavieni.dto.EventDto;
import com.isa.zajavieni.dto.UserDto;
import com.isa.zajavieni.entity.createdentity.Booking;
import com.isa.zajavieni.mapper.dtomapper.BookingDtoMapper;
import com.isa.zajavieni.mapper.dtomapper.EventDtoMapper;
import com.isa.zajavieni.mapper.dtomapper.UserDtoMapper;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

@Stateless
public class BookingService {

  @EJB
  BookingDaoBean bookingDaoBean;

  @EJB
  UserDtoMapper userDtoMapper;

  @EJB
  EventDtoMapper eventDtoMapper;

  @EJB
  BookingDtoMapper bookingDtoMapper;

  public void saveBooking(BookingDto booking) {
    bookingDaoBean.save(bookingDtoMapper.mapDtoToEntity(booking));
  }

  public void deleteBooking(Long id) {
    bookingDaoBean.deleteById(id);
  }

  public BookingDto findByEventAndUser(Long eventId, Long userId) {
    Booking booking = bookingDaoBean.findByEventAndUser(eventId, userId).get();
    BookingDto bookingDto = bookingDtoMapper.mapEntityToDto(booking);
    bookingDto.setEventDto(eventDtoMapper.mapEventToDto(booking.getEvent()));
    bookingDto.setUserDto(userDtoMapper.mapEntityToDto(booking.getUser()));
    return bookingDto;
  }

  @Transactional
  public List<BookingDto> findBookingsForUser(Long id) {
    List<BookingDto> bookings = new ArrayList<>();
    bookingDaoBean.findByUserId(id)
        .forEach(b -> {
          BookingDto bookingDto = bookingDtoMapper.mapEntityToDto(b);
          bookingDto.setEventDto(eventDtoMapper.mapEventToDto(b.getEvent()));
          bookings.add(bookingDto);
        });
    return bookings;
  }

  @Transactional
  public BookingDto createBooking(EventDto event, UserDto user) {
    BookingDto booking = new BookingDto();
    booking.setUserDto(user);
    booking.setEventDto(event);
    event.setTicketPool(event.getTicketPool() - 1);
    return booking;
  }

}
