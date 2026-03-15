package com.example.employee_management;

import java.util.Map;

import com.example.employee_management.service.UtilityService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final UtilityService utilityService;
    private final BCryptPasswordEncoder passwordEncoder;

    public HelloController(UtilityService utilityService, BCryptPasswordEncoder passwordEncoder) {
        this.utilityService = utilityService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/hello")
    public Map<String, String> hello() {
        return Map.of("message", "Hello World");
    }

    @GetMapping("/employee-code")
    public String employeeCode() {
        return utilityService.generateCode();
    }

    @GetMapping("/encode")
    public String encode(@RequestParam String password) {
        return passwordEncoder.encode(password);
    }
}
