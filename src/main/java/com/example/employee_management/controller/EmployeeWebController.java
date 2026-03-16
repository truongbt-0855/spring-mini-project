package com.example.employee_management.controller;

import com.example.employee_management.model.Employee;
import com.example.employee_management.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeWebController {

    private final EmployeeService employeeService;

    public EmployeeWebController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String list(@RequestParam(required = false) String name, Model model) {
        if (name != null && !name.isBlank()) {
            model.addAttribute("employees", employeeService.findByName(name));
        } else {
            model.addAttribute("employees", employeeService.findAll());
        }
        model.addAttribute("name", name);
        return "employees/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employees/add";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return "employees/add";
        }
        employeeService.save(employee);
        return "redirect:/employees/list";
    }
}
