package com.example.quanlykma.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.quanlykma.config.jwt.JwtTokenUtil;
import com.example.quanlykma.model.dto.UserDto;
import com.example.quanlykma.model.response.LoginResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class LoginAPI {
  private final AuthenticationManager authenticationManager;
  private final JwtTokenUtil jwtTokenUtil;
  @PostMapping("/login")
  public ResponseEntity<LoginResponse> login(@RequestBody UserDto userDto){
      Authentication authentication = null;
      LoginResponse loginResponse = new LoginResponse();
      try{
          authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getEmail(), userDto.getPassword()));
          SecurityContextHolder.getContext().setAuthentication(authentication);
          String jwt = jwtTokenUtil.generateToken( authentication);
          loginResponse.setCode(authentication.getAuthorities().toArray()[0].toString());
          loginResponse.setJwttoken(jwt);
      }catch (Exception e){
         //throw new ResourceNotFoundException("Tài khoản","username", userDto.getEmail());
      }
      return new ResponseEntity<>(loginResponse, HttpStatus.OK);
  }
}
