package com.example.quanlykma.model.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class StudentDto extends BaseDto {

  private String fullName;
  private Boolean sex;
  private int age;
  private Date birthday;
  private String majors; // ngành học
  private String introduce; // Giới thiệu
  private String email;
  private String phone;
  private String image;// hình ảnh đại diện nên chỉ cần một ảnh
}
