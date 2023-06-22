package com.example.quanlykma.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.quanlykma.model.dto.TeacherDto;
import com.example.quanlykma.service.ITeacherService;

@CrossOrigin("*")
@RestController(value = "Teacher")
@RequestMapping("/api/teacher")
public class TeacherAPI {

  @Autowired
  private ITeacherService teacherService;
  
  @GetMapping()
  public List<TeacherDto> findAll () {
    return teacherService.findAll();
  }
  
  @PostMapping()
  public void insert (@RequestBody TeacherDto teacherDto) {
    teacherService.insert(teacherDto);
  }
  
  @InitBinder
  public void initBinder(WebDataBinder binder) {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      sdf.setLenient(true);
      binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
  }
}
