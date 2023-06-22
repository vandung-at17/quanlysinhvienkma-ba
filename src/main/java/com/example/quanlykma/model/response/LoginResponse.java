package com.example.quanlykma.model.response;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginResponse implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private String jwttoken;
  private String code;
}
