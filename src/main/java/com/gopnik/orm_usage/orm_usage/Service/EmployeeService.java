package com.gopnik.orm_usage.orm_usage.Service;


import com.gopnik.orm_usage.orm_usage.Repository.DO.Employee;
import com.gopnik.orm_usage.orm_usage.VO.EmployeeDetails;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    List<Employee> getEmployeesByNameOrEmail(String empName);

    List<Employee> findHighSalaryEmployees(String salaryGte);

    List<Employee> findEmployeeByCriteria(String managerName, String havingSalaryGte);

    Employee saveEmployee(EmployeeDetails employee);
}
