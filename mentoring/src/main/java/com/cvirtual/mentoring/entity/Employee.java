package com.cvirtual.mentoring.entity;

import lombok.Data;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Data
@Table(indexes = @Index(columnList = "name"))
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;

    private String name;

    @Temporal(TemporalType.DATE)
    private LocalDate hireDate;

    private String jobName;
}