package com.isa.zajavieni.mapper.dtomapper;

import com.isa.zajavieni.dto.UserDto;
import com.isa.zajavieni.entity.createdentity.User;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

@Stateless
public class UserDtoMapper {

  @EJB
  EventDtoMapper eventDtoMapper;

  @EJB
  BookingDtoMapper bookingDtoMapper;

  @Transactional
  public UserDto mapEntityToDto(User user) {
    UserDto userDto = new UserDto();
    userDto.setId(user.getId());
    userDto.setName(user.getName());
    userDto.setEmail(user.getEmail());
    userDto.setEvents(user.getEvents().stream()
        .map(event -> eventDtoMapper.mapEventToDto(event))
        .collect(Collectors.toList()));
    userDto.setUserType(user.getUserType());
    user.getBookings().forEach(b -> userDto.getBookings()
        .add(bookingDtoMapper.mapEntityToDto(b)));
    return userDto;
  }

  @Transactional
  public User mapDtoToEntity(UserDto userDto) {
    User user = new User();
    user.setName(userDto.getName());
    user.setEmail(userDto.getEmail());
    user.setUserType(userDto.getUserType());
    return user;
  }
}
