package com.example.quanlykma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.quanlykma.converter.UserConverter;
import com.example.quanlykma.entities.UserEntity;
import com.example.quanlykma.model.dto.UserDto;
import com.example.quanlykma.repositories.IUserRepository;
import com.example.quanlykma.service.IUserService;

@Service
public class UserService implements IUserService{

  @Autowired
  private IUserRepository userRepository;
  
  @Autowired
  private UserConverter userConverter;
  
  @Override
  public UserDto findByEmail(String email) {
    // TODO Auto-generated method stub
    UserEntity userEntity = userRepository.findOneByEmail(email);
    UserDto userDto = userConverter.toDto(userEntity);
    return userDto;
  }

}
