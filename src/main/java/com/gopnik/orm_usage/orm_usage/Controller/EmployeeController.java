package com.gopnik.orm_usage.orm_usage.Controller;

import com.gopnik.orm_usage.orm_usage.Repository.DO.Employee;
import com.gopnik.orm_usage.orm_usage.Service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.gopnik.orm_usage.orm_usage.Contants.ApiConstants.API_PREFIX;
import static com.gopnik.orm_usage.orm_usage.Contants.ApiConstants.EMPLOYEE_API_PREFIX;

@RestController
@RequestMapping(API_PREFIX + EMPLOYEE_API_PREFIX)
@Slf4j
public class EmployeeController {

    private static final String GET_ALL_EMPLOYEES = "/getAllEmployees";

    private static final String GET_HIGHER_SALARY_EMPLOYEES = "/high-salary";

    @Autowired
    private EmployeeService employeeService;

    /**
     *
     * @param salaryGte  - Find Salary Greater Than This amount
     * @param userId - userId for logging the user
     * @return List<Employee>  - Return qualified list of employees.
     */

    @GetMapping(GET_HIGHER_SALARY_EMPLOYEES)
    public List<Employee> getHighSalaryEmployees(@RequestParam("salaryGreaterThan") String salaryGte,
                                                 @RequestHeader("requester") String userId) {
        log.info("EmployeeController >> getHighSalaryEmployees >> requester >> {}", userId);
        return employeeService.findHighSalaryEmployees(salaryGte);
    }

    /**
     *
     * @param userId - User requesting for employee list
     * @return List of Employee
     */
    @GetMapping(GET_ALL_EMPLOYEES)
    public List<Employee> getAllEmployees(@RequestHeader String userId) {
        log.info("EmployeeController >> getAllEmployees >> requester >> {}", userId);
        return  employeeService.getAllEmployees();

    }
}

