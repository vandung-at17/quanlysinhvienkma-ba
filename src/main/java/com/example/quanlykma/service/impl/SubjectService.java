package com.example.quanlykma.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.quanlykma.converter.SubjectConverter;
import com.example.quanlykma.entities.SubjectEntity;
import com.example.quanlykma.model.dto.SubjectDto;
import com.example.quanlykma.repositories.ISubjectRepository;
import com.example.quanlykma.service.ISubjectService;

@Service
public class SubjectService implements ISubjectService {

  @Autowired
  private ISubjectRepository subjectRepository;

  @Autowired
  private SubjectConverter subjectConverter;

  @Override
  public List<SubjectDto> findAll() {
    // TODO Auto-generated method stub
    List<SubjectDto> subjectDtos = new ArrayList<>();
    List<SubjectEntity> subjectEntities = subjectRepository.findAll();
    for (SubjectEntity subjectEntity : subjectEntities) {
      SubjectDto subjectDto = subjectConverter.toDto(subjectEntity);
      subjectDtos.add(subjectDto);
    }
    return subjectDtos;
  }

  @Override
  @Transactional
  public void insert(SubjectDto subjectDto) {
    // TODO Auto-generated method stub
    SubjectEntity subjectEntity = subjectConverter.toEntity(subjectDto);
    subjectRepository.save(subjectEntity);
  }

  @Override
  @Transactional
  public void delete(long[] subjectId) {
    // TODO Auto-generated method stub
    for (long id : subjectId) {
      Optional<SubjectEntity> subjectEntity = subjectRepository.findById(id);
      if (subjectEntity.isPresent()) {
        subjectEntity.get().setStatus(false);
        subjectRepository.save(subjectEntity.get());
      } else {
        return;
      }
    }
  }

  @Override
  public SubjectDto findOneByCode(String code) {
    // TODO Auto-generated method stub
    SubjectDto subjectDto = subjectConverter.toDto(subjectRepository.findOneByCode(code));
    return subjectDto;
  }
}


