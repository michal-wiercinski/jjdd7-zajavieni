package com.isa.zajavieni.service;

import com.isa.zajavieni.dao.UserDaoBean;
import com.isa.zajavieni.dto.UserDto;
import com.isa.zajavieni.mapper.UserDtoMapper;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class UserDtoService {

    @EJB
    UserDaoBean userDaoBean;

    @EJB
    UserDtoMapper userDtoMapper;
    public void saveUser(UserDto user){
        userDaoBean.saveUser(userDtoMapper.mapDtoToEntity(user));
    }
}
