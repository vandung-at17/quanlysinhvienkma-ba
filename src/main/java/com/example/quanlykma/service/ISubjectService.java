package com.example.quanlykma.service;

import java.util.List;
import com.example.quanlykma.model.dto.SubjectDto;

public interface ISubjectService {
  List<SubjectDto> findAll ();
  void insert (SubjectDto subjectDto);
  void delete (long subjectId[]);
  SubjectDto findOneByCode(String code);
}
