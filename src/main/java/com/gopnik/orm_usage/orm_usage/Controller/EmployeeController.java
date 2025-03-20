package com.gopnik.orm_usage.orm_usage.Controller;

import com.gopnik.orm_usage.orm_usage.Repository.DO.Employee;
import com.gopnik.orm_usage.orm_usage.Service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.gopnik.orm_usage.orm_usage.Contants.ApiConstants.API_PREFIX;
import static com.gopnik.orm_usage.orm_usage.Contants.ApiConstants.EMPLOYEE_API_PREFIX;

@RestController
@RequestMapping(API_PREFIX + EMPLOYEE_API_PREFIX)
@Slf4j
public class EmployeeController {

    private static final String GET_ALL_EMPLOYEES = "/getAllEmployees";

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/high-salary")
    public List<Employee> getHighSalaryEmployees() {
        return List.of(new Employee());//employeeService.getHighSalaryEmployees();
    }

    @GetMapping(GET_ALL_EMPLOYEES)
    public List<Employee> getAllEmployees(@RequestHeader String userId) {
        log.info("EmployeeController >> getAllEmployees >> requester >> {}", userId);
        return  employeeService.getAllEmployees();

    }
}

