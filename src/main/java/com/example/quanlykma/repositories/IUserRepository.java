package com.example.quanlykma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.quanlykma.entities.UserEntity;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long>{

  public UserEntity findOneByEmail (String email);
}
