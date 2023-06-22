package com.example.quanlykma.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import com.example.quanlykma.entities.StudentEntity;
import com.example.quanlykma.model.dto.StudentDto;

@Component
public class StudentConverter {
  public StudentDto toDto(StudentEntity studentEntity) {
    StudentDto studentDto = new StudentDto();
    BeanUtils.copyProperties(studentEntity, studentDto);
    return studentDto;
  }

  public StudentEntity toEntity(StudentDto studentDto) {
    StudentEntity studentEntity = new StudentEntity();
    BeanUtils.copyProperties(studentDto, studentEntity);
    return studentEntity;
  }
}
