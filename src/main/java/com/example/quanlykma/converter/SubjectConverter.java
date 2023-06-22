package com.example.quanlykma.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import com.example.quanlykma.entities.SubjectEntity;
import com.example.quanlykma.model.dto.SubjectDto;

@Component
public class SubjectConverter {
  public SubjectDto toDto(SubjectEntity subjectEntity) {
    SubjectDto subjectDto = new SubjectDto();
    BeanUtils.copyProperties(subjectEntity, subjectDto);
    return subjectDto;
  }

  public SubjectEntity toEntity(SubjectDto subjectDto) {
    SubjectEntity subjectEntity = new SubjectEntity();
    BeanUtils.copyProperties(subjectDto, subjectEntity);
    return subjectEntity;
  }
}
