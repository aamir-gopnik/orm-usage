package com.gopnik.orm_usage.orm_usage.Service;

import com.gopnik.orm_usage.orm_usage.Repository.DO.Employee;
import com.gopnik.orm_usage.orm_usage.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> GetEmployeesByNameOrEmail() {
        return null;

    }

    @Override
    public List<Employee> findHighSalaryEmployees(String salaryGte) {
        double updatedSalaryGte = Double.parseDouble(salaryGte);
        return employeeRepository.findHighSalaryEmployees(updatedSalaryGte);
    }


}
