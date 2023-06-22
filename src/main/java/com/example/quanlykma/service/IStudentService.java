package com.example.quanlykma.service;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;
import com.example.quanlykma.model.dto.StudentDto;

public interface IStudentService {
  List<StudentDto> findAll();
  public List<StudentDto> findAllStudentOfPage(Pageable pageable);
  public List<StudentDto> findAllStudentOfPageAndName(String name, Pageable pageable);
  public long getTotalItem();
  public long getTotalItem(String name);
  void insert (StudentDto studentDto);
  public StudentDto inserts (StudentDto studentDto, MultipartFile multipartFile);
  void delete (long studentId[]);
  void drop (List<Long> studentId);
  StudentDto findOneById (long id);
}
