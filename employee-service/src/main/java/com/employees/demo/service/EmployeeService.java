package com.employees.demo.service;

import com.employees.demo.entity.EmployeeDTO;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    EmployeeDTO getAllEmployee();

    EmployeeDTO getByAge(Integer age);
}
