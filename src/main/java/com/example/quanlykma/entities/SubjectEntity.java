package com.example.quanlykma.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(name = "subject")
public class SubjectEntity extends BaseEntity implements Serializable {

  @Column(name = "code", unique = true, nullable = false)
  private String code;

  @Column(name = "name")
  private String name;
  
  @ManyToMany(mappedBy = "subjectEntities")
  private List<StudentEntity> studentEntities = new ArrayList<>();
  
  @OneToMany(mappedBy = "subjectEntity")
  private List<TeacherEntity> teacherEntities = new ArrayList<>();
}
