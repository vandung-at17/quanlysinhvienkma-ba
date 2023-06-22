package com.example.quanlykma.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.quanlykma.converter.TeacherConverter;
import com.example.quanlykma.entities.TeacherEntity;
import com.example.quanlykma.model.dto.TeacherDto;
import com.example.quanlykma.repositories.ITeacherRepository;
import com.example.quanlykma.service.ITeacherService;

@Service
public class TeacherService implements ITeacherService{
  
  @Autowired
  private ITeacherRepository teacherRepository;
  
  @Autowired
  private TeacherConverter teacherConverter;

  @Override
  public List<TeacherDto> findAll() {
    // TODO Auto-generated method stub
    List<TeacherDto> teacherDtos = new ArrayList<>();
    List<TeacherEntity> teacherEntities= teacherRepository.findAll();
    for (TeacherEntity teacherEntity : teacherEntities) {
      TeacherDto teacherDto = teacherConverter.toDto(teacherEntity);
      teacherDtos.add(teacherDto);
    }
    return teacherDtos;
  }

  @Override
  @Transactional
  public void insert(TeacherDto teacherDto) {
    // TODO Auto-generated method stub
    TeacherEntity teacherEntity = teacherConverter.toEntity(teacherDto);
    teacherRepository.save(teacherEntity);
  }

  @Override
  @Transactional
  public void delete(long[] teacherId) {
    // TODO Auto-generated method stub
    for (long id : teacherId) {
        Optional<TeacherEntity> teacherEntity = teacherRepository.findById(id);
        if (teacherEntity.isPresent()) {
          teacherEntity.get().setStatus(false);
          teacherRepository.save(teacherEntity.get());
        }else {
          return ;
        }
    }
  }

}
