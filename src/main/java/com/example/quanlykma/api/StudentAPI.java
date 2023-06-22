package com.example.quanlykma.api;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.quanlykma.model.dto.StudentDto;
import com.example.quanlykma.service.IStudentService;
import com.fasterxml.jackson.databind.ObjectMapper;


@CrossOrigin
@RestController(value = "Student")
@RequestMapping("/api/student")
public class StudentAPI {

  @Autowired
  private IStudentService studentService;

  @GetMapping(value = "/page")
  public List<StudentDto> findStudent(@RequestParam int currentPage, @RequestParam int limit,
      @RequestParam(value = "key", required = false) String key) {
    Pageable pageable = PageRequest.of(currentPage - 1, limit);
    List<StudentDto> studentDtos = new ArrayList<>();
    if (key == null || key.isEmpty()) {
      studentDtos = studentService.findAllStudentOfPage(pageable);
    } else {
      studentDtos = studentService.findAllStudentOfPageAndName(key, pageable);
    }
    return studentDtos;
  }

  @GetMapping()
  public List<StudentDto> findAll() {
    return studentService.findAll();
  }

  // @GetMapping(value="/totalItem")
  // public long getTotalItem() {
  // return studentService.getTotalItem();
  // }

  @GetMapping(value = "/totalItem")
  public long getTotalItem(@RequestParam(value = "key", required = false) String key) {
    if (key == null || key.isEmpty()) {
      return studentService.getTotalItem();
    } else {
      return studentService.getTotalItem(key);
    }
  }
  
  @GetMapping(value ="/detail")
  public ResponseEntity<StudentDto> detailStudent (@RequestParam(value="id") Long id) {
    if (id != null && id>0) {
      StudentDto studentDto = studentService.findOneById(id);
      return new ResponseEntity<>(studentDto,HttpStatus.OK);
    }
    return null;
  }
  

  @PostMapping()
  public void insert(@RequestBody StudentDto studentDto) {
    studentService.insert(studentDto);
  }
  
//  @PostMapping("/image")
//  public void inserts (@RequestBody StudentDto studentDto, MultipartFile multipartFile) {
//    studentDto = studentService.inserts(studentDto, multipartFile);
//  }
  
  @PostMapping("/image")
  public ResponseEntity<String> uploadStudent (@RequestParam("image") MultipartFile image,
      @RequestParam("student") String studentJson) {
    try {
      // Xử lý và lưu trữ thông tin sinh viên, hình ảnh và trường anhr vào cơ sở dữ liệu
      ObjectMapper objectMapper = new ObjectMapper();
      StudentDto studentDto = objectMapper.readValue(studentJson, StudentDto.class);
      studentDto = studentService.inserts(studentDto, image);
      return ResponseEntity.ok("Upload successful");
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request data");
    }
  }
  

  @DeleteMapping
  public ResponseEntity<String> deleteStudents(@RequestParam long[] ids) {
    studentService.delete(ids);
    return new ResponseEntity<>("Xóa sinh viên thành công", HttpStatus.OK);
  }
  
  @DeleteMapping("/delete")
  public ResponseEntity<String> dropStudents (@RequestParam List<Long> ids) {
    studentService.drop(ids);
    return new ResponseEntity<>("Xóa sinh viên thành công", HttpStatus.OK);
  }

  @PutMapping
  public void updateStudent(@RequestBody StudentDto studentDto) {
    StudentDto oldstudent = studentService.findOneById(studentDto.getId());
    if (oldstudent != null) {
      studentDto.setModifiedDate(new Timestamp(System.currentTimeMillis()));
      studentService.insert(studentDto);
    }
  }
  
  @PutMapping("/image")
  public ResponseEntity<String> updateStudent(@RequestParam("image") MultipartFile multipartFile, @RequestParam("student") String studentJson) {
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      StudentDto studentDto = objectMapper.readValue(studentJson, StudentDto.class);
      studentDto = studentService.inserts(studentDto, multipartFile);
      return ResponseEntity.ok("Update Student ok");
    } catch (Exception e) {
      // TODO: handle exception
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Kiểu dữ liệu chưa đúng hoặc chưa hợp lệ");
    }
  }
  
  @InitBinder
  public void initBinder(WebDataBinder binder) {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      sdf.setLenient(true);
      binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
  }
}
