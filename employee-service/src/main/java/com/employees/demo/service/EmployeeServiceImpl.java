package com.employees.demo.service;

import com.employees.demo.entity.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Value("${endpoint}")
    private String url;

    private final RestTemplate restTemplate;

    @Autowired
    public EmployeeServiceImpl(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
    }




    @Override
    public EmployeeDTO getAllEmployee() {
        return restTemplate.getForObject(url, EmployeeDTO.class);
    }


    @Override
    public EmployeeDTO getByAge(Integer age) {
        EmployeeDTO employeeDTO = getAllEmployee();
        employeeDTO.setEmployeeList(employeeDTO.getEmployeeList()
                .stream()
                .filter(e -> e.getEmployee_age() > age)
                .collect(Collectors.toList()));
        return employeeDTO;

    }
}
