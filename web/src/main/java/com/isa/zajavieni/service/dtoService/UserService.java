package com.isa.zajavieni.service.dtoService;

import com.isa.zajavieni.dao.BookingDaoBean;
import com.isa.zajavieni.dao.UserDaoBean;
import com.isa.zajavieni.dto.UserDto;
import com.isa.zajavieni.entity.Booking;
import com.isa.zajavieni.entity.User;
import com.isa.zajavieni.entity.UserType;
import com.isa.zajavieni.mapper.dtoMapper.UserDtoMapper;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

@Transactional
@Stateless
public class UserService {

  private static final String CREDENTIALS_FILE = "credentials.properties";

  @EJB
  UserDaoBean userDaoBean;

  @EJB
  UserDtoMapper userDtoMapper;

  @EJB
  BookingDaoBean bookingDaoBean;

  public User findUserById(Long id) {
    return userDaoBean.findById(id);
  }

  @Transactional
  public UserDto findUserDtoById(Long id){
    return userDtoMapper.mapEntityToDto(findUserById(id));
  }

  public void createNewUser(UserDto userDto) throws IOException {
    User user = userDtoMapper.mapDtoToEntity(userDto);
    if (userDto.getEmail().equals(getAdminEmail())) {
      user.setUserType(UserType.SUPER_ADMIN);
    } else {
      user.setUserType(UserType.USER);
    }
    userDaoBean.saveUser(user);
  }

  public void editUser(User user) {
    userDaoBean.updateUser(user);
  }
  public void editDtoUser(UserDto user) {
    userDaoBean.updateUser(userDtoMapper.mapDtoToEntity(user));
  }

  public Optional<UserDto> getUserByEmail(String email) {
    return userDaoBean.findByEmail(email).map(userDtoMapper::mapEntityToDto);
  }

  public Boolean userExists(String email) {
    return userDaoBean.findByEmail(email).isPresent();
  }

  public Boolean isAdmin(String email) {
    Optional<User> user = userDaoBean.findByEmail(email);

    return user.map(value -> value.getUserType()
        .equals(UserType.ADMIN))
        .orElse(false);
  }

  public Boolean isSuperAdmin(String email) {
    Optional<User> user = userDaoBean.findByEmail(email);

    return user.map(value -> value.getUserType()
        .equals(UserType.SUPER_ADMIN))
        .orElse(false);
  }

  public List<UserDto> getUsers() {
    return userDaoBean.findAll().stream()
        .map(user -> userDtoMapper.mapEntityToDto(user))
        .collect(Collectors.toList());
  }

  private static String getAdminEmail() throws IOException {
    Properties settings = new Properties();
    settings.load(Objects.requireNonNull(Thread.currentThread()
        .getContextClassLoader().getResource(CREDENTIALS_FILE))
        .openStream());
    return settings.getProperty("user.name");
  }

  public Optional<User> findByEmail(String email) {
    return userDaoBean.findByEmail(email);
  }

}