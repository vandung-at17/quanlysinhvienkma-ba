package com.example.quanlykma.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "role")
public class RoleEntity extends BaseEntity implements Serializable {

  @Column(name = "code", unique = true, nullable = false)
  @NotNull
  private String code;

  @Column(name = "name" ,nullable = false)
  private String name;
  
  @ManyToMany(mappedBy = "roleEntities")
  private List<UserEntity> userEntities = new ArrayList<>();
}
