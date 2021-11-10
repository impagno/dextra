package com.cvirtual.mentoring.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
@Table(indexes = @Index(columnList = "name"))
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    private Long id;

    private String name;

    @Temporal(TemporalType.DATE)
    private Date hireDate;

    private String jobName;
}