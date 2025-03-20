package com.gopnik.orm_usage.orm_usage.Service;


import com.gopnik.orm_usage.orm_usage.Repository.DO.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    List<Employee> GetEmployeesByNameOrEmail();

    List<Employee> findHighSalaryEmployees(String salaryGte);
}
