package com.example.employee_management.repository;

import com.example.employee_management.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public List<Employee> findByNameContaining(String name);
    public List<Employee> findByDepartmentId(Long departmentId);
}