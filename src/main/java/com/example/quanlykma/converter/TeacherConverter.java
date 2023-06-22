package com.example.quanlykma.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import com.example.quanlykma.entities.TeacherEntity;
import com.example.quanlykma.model.dto.TeacherDto;

@Component
public class TeacherConverter {
  public TeacherDto toDto(TeacherEntity teacherEntity) {
    TeacherDto teacherDto = new TeacherDto();
    BeanUtils.copyProperties(teacherEntity, teacherDto);
    return teacherDto;
  }

  public TeacherEntity toEntity(TeacherDto teacherDto) {
    TeacherEntity teacherEntity = new TeacherEntity();
    BeanUtils.copyProperties(teacherDto, teacherEntity);
    return teacherEntity;
  }
}
