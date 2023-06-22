package com.example.quanlykma.config.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.quanlykma.model.dto.UserDto;
import com.example.quanlykma.model.request.JwtRequest;
import com.example.quanlykma.model.response.JwtResponse;

/*
 * Expose a POST API /authenticate using the JwtAuthenticationController. The POST API gets username
 * and password in the body- Using Spring Authentication Manager we authenticate the username and
 * password.If the credentials are valid, a JWT token is created using the JWTTokenUtil and provided
 * to the client.
 */
@RestController
@CrossOrigin
public class JwtAuthenticationController {
//  @Autowired
//  private IUserService userService;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Autowired
  private JwtUserDetailsService userDetailsService;

  @PostMapping(value = "/register")
  public ResponseEntity<?> saveUser(@RequestBody UserDto userDto) throws Exception {
    return ResponseEntity.ok(userDetailsService.save(userDto));
  }

  @PostMapping(value = "/authenticate")
  public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
      throws Exception {

     authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
      final UserDetails userDetails =
          userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

      final String token = jwtTokenUtil.generateToken(userDetails);

      return ResponseEntity.ok(new JwtResponse(token));

  }


  private void authenticate(String email, String password) throws Exception {
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
    } catch (DisabledException e) {
      throw new Exception("USER_DISABLED", e);
    } catch (BadCredentialsException e) {
      throw new Exception("INVALID_CREDENTIALS", e);
    }
  }
}
