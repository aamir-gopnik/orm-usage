package com.gopnik.orm_usage.orm_usage.Service;

import com.gopnik.orm_usage.orm_usage.Repository.DO.Employee;
import com.gopnik.orm_usage.orm_usage.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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
    public List<Employee> getEmployeesByNameOrEmail(String empName) {
        return employeeRepository.findByName(empName);

    }

    @Override
    public List<Employee> findHighSalaryEmployees(String salaryGte) {
        double updatedSalaryGte = Double.parseDouble(salaryGte);
        return employeeRepository.findHighSalaryEmployees(updatedSalaryGte);
    }

    @Override
    public List<Employee> findEmployeeByCriteria(String managerName, String havingSalaryGte) {
        boolean fetchByManagerName = false;
        boolean fetchBySalaryGte = false;
        double updatedSalaryGte = 0.0D;
        if(!ObjectUtils.isEmpty(managerName))
        {
            fetchByManagerName = true;
        }

        if(!ObjectUtils.isEmpty(havingSalaryGte))
        {
            updatedSalaryGte = Double.parseDouble(havingSalaryGte);
            fetchBySalaryGte = true;
        }

        if(fetchByManagerName  && fetchBySalaryGte)
        {
            return employeeRepository.findByGivenCriteria(managerName,updatedSalaryGte);
        }
        else if (fetchByManagerName) {
            return employeeRepository.findByGivenCriteria(managerName);
        }
        else {
            return employeeRepository.findHighSalaryEmployees(updatedSalaryGte);
        }
    }
}
