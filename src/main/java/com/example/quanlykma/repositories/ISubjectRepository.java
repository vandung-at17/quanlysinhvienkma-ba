package com.example.quanlykma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.quanlykma.entities.SubjectEntity;

@Repository
public interface ISubjectRepository extends JpaRepository<SubjectEntity, Long>{

  SubjectEntity findOneByCode (String code);

}
