package com.example.quanlykma.model.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseDto {
  private long id;

  private Date createdDate;

  private Date modifiedDate;

  private String createdBy;

  private String modifiedBy;

  private Boolean status;
}
