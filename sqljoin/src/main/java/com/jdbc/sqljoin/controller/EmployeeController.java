package com.jdbc.sqljoin.controller;

import java.util.List;

import com.jdbc.sqljoin.model.Employee;
import com.jdbc.sqljoin.repository.EmployeeRepository;
import com.jdbc.sqljoin.repository.GetMapping;


@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(value = "")
    public List<Employee> getEmployees() {  
        return employeeRepository.getAllEmployees();  // ✅ Calls the implemented method
    }
}
