package com.example.quanlykma.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import com.example.quanlykma.entities.RoleEntity;
import com.example.quanlykma.model.dto.RoleDto;

@Component
public class RoleConverter {
  public RoleDto toDto(RoleEntity roleEntity) {
    RoleDto roleDto = new RoleDto();
    BeanUtils.copyProperties(roleEntity, roleDto);
    return roleDto;
  }

  public RoleEntity toEntity(RoleDto roleDto) {
    RoleEntity roleEntity = new RoleEntity();
    BeanUtils.copyProperties(roleDto, roleEntity);
    return roleEntity;
  }
}
