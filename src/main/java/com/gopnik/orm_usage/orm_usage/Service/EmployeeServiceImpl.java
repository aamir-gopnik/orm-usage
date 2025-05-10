package com.gopnik.orm_usage.orm_usage.Service;

import com.gopnik.orm_usage.orm_usage.Repository.DO.Employee;
import com.gopnik.orm_usage.orm_usage.Repository.DO.Manager;
import com.gopnik.orm_usage.orm_usage.Repository.EmployeeRepository;
import com.gopnik.orm_usage.orm_usage.Repository.ManagerRepository;
import com.gopnik.orm_usage.orm_usage.VO.EmployeeDetails;
import com.gopnik.orm_usage.orm_usage.VO.ManagerDetails;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService, BeanNameAware {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ManagerRepository managerRepository;

    public EmployeeServiceImpl() {
        System.out.println("EmployeeServiceImpl >> object created for employeeserviceimpl class");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware >> setting bean name >>" + name);
    }

    @PreDestroy
    public void preDestroyCleanup() {
        System.out.println("@PreDestroy method >> inside preDestroy cleanup");
    }

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

    @Override
    public Employee saveEmployee(EmployeeDetails employee) {
        Employee newEmp = Employee.builder().name(employee.getName())
                .salary(employee.getSalary())
                .build();
        Optional<Long> managerId = Optional.ofNullable(employee.getManagerDetails().getId());
        if(managerId.isPresent())
        {
            log.info("EmployeeServiceImpl >> saveEmployee >> saving employee for ManagerId {}", managerId.get());
            Optional<Manager> existingManager = managerRepository.findById(managerId.get());
            if(existingManager.isPresent())
            {
                newEmp.setManager(existingManager.get());
                return employeeRepository.save(newEmp);
            }
        }
        else {
            log.info("EmployeeServiceImpl >> saveEmployee >> saving employee for new Manager {}",
                    employee.getManagerDetails().getName());
            ManagerDetails newManager = employee.getManagerDetails();
            Manager managerDO = Manager.builder()
                    .name(newManager.getName())
                    .salary(newManager.getSalary())
                    .build();
            newEmp.setManager(managerDO);
        }
        return employeeRepository.save(newEmp);
    }
}
