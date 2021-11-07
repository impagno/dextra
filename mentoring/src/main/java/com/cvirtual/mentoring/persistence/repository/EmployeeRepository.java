package com.cvirtual.mentoring.persistence.repository;

import com.cvirtual.mentoring.entity.Employee;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    
}
