package com.example.employee_management.service;

import org.springframework.stereotype.Service;

@Service
public class UtilityService {
    public String generateCode() {
        return "EMP-" + (int) (Math.random() * 10000);
    }
}
