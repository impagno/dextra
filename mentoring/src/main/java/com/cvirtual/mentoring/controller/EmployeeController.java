package com.cvirtual.mentoring.controller;

import java.util.ArrayList;
import java.util.List;

import com.cvirtual.mentoring.entity.Employee;
import com.cvirtual.mentoring.persistence.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;
    
    @GetMapping
    public HttpEntity<List<Employee>> getAll() {
        List<Employee> list = new ArrayList<>();

        employeeRepository.findAll().forEach(list::add);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<Employee> getById(@PathVariable Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        HttpStatus status = employee == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;

        return new ResponseEntity<>(employee, status);
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
