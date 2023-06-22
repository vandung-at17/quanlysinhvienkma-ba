package com.example.quanlykma.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "student")
public class StudentEntity extends BaseEntity implements Serializable {

  @Column(name = "fullname",nullable = false)
  private String fullName;
  
  @Column(name = "sex")
  private Boolean sex;

  @Column(name = "age", nullable = false)
  private int age;

  @Column(name = "birthday")
  private Date birthday;

  @Column(name = "majors", nullable = false)
  private String majors; // ngành học
  
  @Column(name ="introduce")
  private String introduce; // Giới thiệu

  @Column(name = "email", unique = true, nullable = false)
  @Email(message = "Email is not valid")
  private String email;
  
  @Column(name = "phone", nullable = false)
  private String phone;
  
  @Column (name ="image")
  private String image;
  
  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinTable(name = "student_subject",
      joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "id"))
  private List<SubjectEntity> subjectEntities;
}
