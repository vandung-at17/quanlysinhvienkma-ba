package com.example.quanlykma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.quanlykma.entities.TeacherEntity;

@Repository
public interface ITeacherRepository extends JpaRepository<TeacherEntity, Long>{

}
