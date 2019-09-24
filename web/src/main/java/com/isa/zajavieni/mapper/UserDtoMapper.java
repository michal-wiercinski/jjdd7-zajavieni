package com.isa.zajavieni.mapper;

import com.isa.zajavieni.dto.UserDto;
import com.isa.zajavieni.entity.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.stream.Collectors;

@Stateless
public class UserDtoMapper {

    @EJB
    EventDtoMapper eventDtoMapper;

    public UserDto mapEntityToDto(User user) {
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setEvents(user.getEvents().stream()
                .map(event -> eventDtoMapper.mapEventToDto(event))
                .collect(Collectors.toList()));
        userDto.setUserType(user.getUserType());

        return userDto;
    }

    public User mapDtoToEntity(UserDto userDto) {
        User user = new User();

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setUserType(userDto.getUserType());

        return user;
    }
}
