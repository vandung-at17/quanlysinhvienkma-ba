package com.example.quanlykma.service;

import java.util.List;
import com.example.quanlykma.model.dto.TeacherDto;

public interface ITeacherService {
  List<TeacherDto> findAll();
  void insert (TeacherDto teacherDto);
  void delete (long teacherId[]);
}
