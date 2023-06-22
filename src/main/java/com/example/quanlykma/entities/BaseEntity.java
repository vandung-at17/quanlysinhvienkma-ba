package com.example.quanlykma.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @CreatedDate
    @Column(name = "createddate")
    private Date createdDate;
    
    @LastModifiedDate
    @Column(name = "modifieddate")
    private Date modifiedDate;
    
    @CreatedBy
    @Column(name = "createdby")
    private String createdBy;
    
    @LastModifiedBy
    @Column(name = "modifiedby")
    private String modifiedBy;
    
    @Column(name="status", nullable = false)
    private Boolean status;
}
