package com.example.employee_management.controller;

import com.example.employee_management.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private List<Employee> employees = new ArrayList<>();

    @GetMapping("")
    public ResponseEntity<List<Employee>> employees() {
        return ResponseEntity.ok(employees);
    }

    @PostMapping("")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        employees.add(employee);
        return ResponseEntity.status(201).body(employee); // 201 Created
    }
}
