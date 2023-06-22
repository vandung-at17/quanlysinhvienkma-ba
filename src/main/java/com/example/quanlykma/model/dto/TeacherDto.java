package com.example.quanlykma.model.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TeacherDto extends BaseDto {
  
  private String fullName;
  private Boolean sex;
  private int age;
  
  private Date birthday;
  
  private String introduce; // Giới thiệu
  
  private String email;
  private String phone;
}
