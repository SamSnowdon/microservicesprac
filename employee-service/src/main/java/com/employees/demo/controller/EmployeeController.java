package com.employees.demo.controller;

import com.employees.demo.entity.Employee;
import com.employees.demo.entity.EmployeeDTO;
import com.employees.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping()
    public List<Employee> getEmployees(){
        return service.getAllEmployee().getEmployeeList();
    }

    @GetMapping(params = "age")
    public EmployeeDTO getEmplyeesOverThirty(Integer age){
        return service.getByAge(age);
    }


}
