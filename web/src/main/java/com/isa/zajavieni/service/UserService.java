package com.isa.zajavieni.service;

import com.isa.zajavieni.dao.UserDaoBean;
import com.isa.zajavieni.dto.UserDto;
import com.isa.zajavieni.entity.User;
import com.isa.zajavieni.entity.UserType;
import com.isa.zajavieni.mapper.UserDtoMapper;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;

@Transactional
@Stateless
public class UserService {

    private static final String CREDENTIALS_FILE = "credentials.properties";

    @EJB
    UserDaoBean userDaoBean;

    @EJB
    UserDtoMapper userDtoMapper;

    public void createNewUser(UserDto userDto) throws IOException {
        User user = userDtoMapper.mapDtoToEntity(userDto);
        if(userDto.getEmail().equals(getAdminEmail())){
            user.setUserType(UserType.ADMIN);
        }else{
            user.setUserType(UserType.USER);
        }
        userDaoBean.saveUser(user);
    }

    public Optional<UserDto> getUserByEmail(String email){
        return userDaoBean.findByEmail(email).map(userDtoMapper::mapEntityToDto);

    }

   public Boolean ifExist(String email){
      return userDaoBean.findByEmail(email).isPresent();
   }

   public Boolean isAdmin(String email){
       Optional<User> user = userDaoBean.findByEmail(email);

       return user.map(value -> value.getUserType()
               .equals(UserType.ADMIN))
               .orElse(false);
   }

   public List<UserDto> getUsers(){
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


}
