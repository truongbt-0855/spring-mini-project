package com.example.employee_management.controller;

import com.example.employee_management.model.Employee;
import com.example.employee_management.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public ResponseEntity<List<Employee>> employees() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @PostMapping("")
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {
        return ResponseEntity.status(201).body(employeeService.save(employee));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Employee>> searchByName(@RequestParam String name) {
        return ResponseEntity.ok(employeeService.findByName(name));
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<Employee>> getByDepartment(@PathVariable Long departmentId) {
        return ResponseEntity.ok(employeeService.findByDepartmentId(departmentId));
    }
}
