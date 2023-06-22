package com.example.quanlykma.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.quanlykma.entities.StudentEntity;

@Repository
public interface IStudentRepository extends JpaRepository<StudentEntity, Long> {
  
  @Query(value="SELECT count(*) FROM student as s where s.fullname like %:keyword% ", nativeQuery = true)
  long getTotalItem(@Param("keyword") String keyword);
  
  @Query(value="SELECT s.* FROM student as s where  s.fullname like %:keyword%",
      countQuery= "SELECT count(*) FROM student as s where  s.fullname like %:keyword% ",
      nativeQuery = true)
  Page<StudentEntity> findByNameOfPage(@Param("keyword") String keyword, Pageable pageable);
}
