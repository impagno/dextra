package com.cvirtual.mentoring.controller;

import java.util.ArrayList;
import java.util.List;

import com.cvirtual.mentoring.entity.Employee;
import com.cvirtual.mentoring.persistence.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;
    
    @GetMapping
    public List<Employee> getAll() {
        List<Employee> list = new ArrayList<>();

        employeeRepository.findAll().forEach(list::add);
        return list;
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @PostMapping
    public void add(@RequestBody Employee employee) {
        employeeRepository.save(employee);
    }

    @DeleteMapping
    public void delete(@RequestBody Employee employee) {
        employeeRepository.delete(employee);
    }
}
