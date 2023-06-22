package com.example.quanlykma.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.example.quanlykma.converter.StudentConverter;
import com.example.quanlykma.entities.StudentEntity;
import com.example.quanlykma.model.dto.StudentDto;
import com.example.quanlykma.repositories.IStudentRepository;
import com.example.quanlykma.service.IStudentService;

@Service
public class StudentService implements IStudentService {

  @Value("${upload.path}")
  private String pathUploadImage;
  //Vị trí lưu file là :"/upload/images"

  @Autowired
  private IStudentRepository studentRepository;

  @Autowired
  private StudentConverter studentConverter;

  @Override
  public List<StudentDto> findAll() {
    // TODO Auto-generated method stub
    List<StudentDto> studentDtos = new ArrayList<>();
    List<StudentEntity> studentEntities = studentRepository.findAll();
    for (StudentEntity studentEntity : studentEntities) {
      StudentDto studentDto = studentConverter.toDto(studentEntity);
      studentDtos.add(studentDto);
    }
    return studentDtos;
  }

  @Override
  @Transactional
  public void insert(StudentDto studentDto) {
    studentDto.setStatus(true);
    // TODO Auto-generated method stub
    studentDto.setCreatedDate(new Timestamp(System.currentTimeMillis()));
    studentDto.setModifiedDate(new Timestamp(System.currentTimeMillis()));
    StudentEntity studentEntity = studentConverter.toEntity(studentDto);
    studentRepository.save(studentEntity);
  }

  @Override
  @Transactional
  public void delete(long[] studentId) {
    // TODO Auto-generated method stub
    for (long id : studentId) {
      Optional<StudentEntity> studentEntity = studentRepository.findById(id);
      if (studentEntity.isPresent()) {
        studentEntity.get().setStatus(false);
        studentRepository.save(studentEntity.get());
      } else {
        return;
      }
    }
  }

  @Override
  public StudentDto findOneById(long id) {
    // TODO Auto-generated method stub
    Optional<StudentEntity> studentEntity = studentRepository.findById(id);
    if (studentEntity.isPresent()) {
      return studentConverter.toDto(studentEntity.get());
    } else {
      return null;
    }
  }

  @Override
  public long getTotalItem() {
    // TODO Auto-generated method stub
    long totalItem = studentRepository.count();
    return totalItem;
  }

  @Override
  public List<StudentDto> findAllStudentOfPage(Pageable pageable) {
    // TODO Auto-generated method stub
    List<StudentDto> studentDtos = new ArrayList<>();
    List<StudentEntity> studentEntities = studentRepository.findAll(pageable).getContent();
    for (StudentEntity studentEntity : studentEntities) {
      StudentDto studentDto = studentConverter.toDto(studentEntity);
      studentDtos.add(studentDto);
    }
    return studentDtos;
  }

  @Override
  public long getTotalItem(String name) {
    // TODO Auto-generated method stub
    long totalItem = studentRepository.getTotalItem(name);
    return totalItem;
  }

  @Override
  public List<StudentDto> findAllStudentOfPageAndName(String name, Pageable pageable) {
    // TODO Auto-generated method stub
    List<StudentDto> studentDtos = new ArrayList<>();
    List<StudentEntity> studentEntities =
        studentRepository.findByNameOfPage(name, pageable).getContent();
    for (StudentEntity studentEntity : studentEntities) {
      StudentDto studentDto = studentConverter.toDto(studentEntity);
      studentDtos.add(studentDto);
    }
    return studentDtos;
  }

  @Override
  @Transactional
  public StudentDto inserts(StudentDto studentDto, MultipartFile multipartFile) {
    // TODO Auto-generated method stub
    try {
      File file = new File(pathUploadImage + "/" + multipartFile.getOriginalFilename());
      FileOutputStream fos = new FileOutputStream(file);
      fos.write(multipartFile.getBytes());
      fos.close();
  }catch (IOException e) {
      // TODO: handle exception
      e.printStackTrace();
      System.out.println("Lỗi ở phần StudentService lưu file ảnh");
      System.out.println(e.getMessage());
  }
    studentDto.setImage(multipartFile.getOriginalFilename());
    studentDto.setCreatedDate(new Timestamp(System.currentTimeMillis()));
    studentDto.setModifiedDate(new Timestamp(System.currentTimeMillis()));
    studentDto.setStatus(true);
    StudentEntity studentEntity = studentConverter.toEntity(studentDto);
    studentRepository.save(studentEntity);
    return studentDto;
  }

  @Override
  public void drop(List<Long> studentId) {
    // TODO Auto-generated method stub
    studentRepository.deleteAllByIdInBatch(studentId);
  }


}
