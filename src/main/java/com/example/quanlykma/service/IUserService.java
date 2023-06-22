package com.example.quanlykma.service;

import com.example.quanlykma.model.dto.UserDto;

public interface IUserService {
  public UserDto findByEmail (String email);
}
