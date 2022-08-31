package com.employees.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeDTO {

    @JsonProperty("data")
    private List<Employee> employeeList;

}
