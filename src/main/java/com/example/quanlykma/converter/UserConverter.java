package com.example.quanlykma.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import com.example.quanlykma.entities.UserEntity;
import com.example.quanlykma.model.dto.UserDto;

@Component
public class UserConverter {
  public UserDto toDto(UserEntity userEntity) {
    UserDto userDto = new UserDto();
    BeanUtils.copyProperties(userEntity, userDto);
    return userDto;
  }

  public UserEntity toEntity(UserDto userDto) {
    UserEntity userEntity = new UserEntity();
    BeanUtils.copyProperties(userDto, userEntity);
    return userEntity;
  }
}
