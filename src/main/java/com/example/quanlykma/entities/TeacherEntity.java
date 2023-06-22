package com.example.quanlykma.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "teacher")
public class TeacherEntity extends BaseEntity implements Serializable {

  @Column(name = "fullname", nullable = false)
  private String fullName;
  
  @Column(name = "sex")
  private Boolean sex;

  @Column(name = "age", nullable = false)
  private int age;

  @Column(name = "birthday")
  private Date birthday;
  
  @Column(name ="introduce")
  private String introduce; // Giới thiệu

  @Column(name = "email", unique = true, nullable = false)
  @Email(message = "Email is not valid")
  private String email;
  
  @Column(name = "phone", nullable = false)
  private String phone;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name= "subject_id")
  private SubjectEntity subjectEntity;
}
