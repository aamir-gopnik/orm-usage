package com.gopnik.orm_usage.orm_usage.Controller;

import com.gopnik.orm_usage.orm_usage.Repository.DO.Employee;
import com.gopnik.orm_usage.orm_usage.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/high-salary")
    public List<Employee> getHighSalaryEmployees() {
        return List.of(new Employee());//employeeService.getHighSalaryEmployees();
    }
}
