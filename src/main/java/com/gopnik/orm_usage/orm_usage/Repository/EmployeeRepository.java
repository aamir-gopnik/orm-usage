package com.gopnik.orm_usage.orm_usage.Repository;

import com.gopnik.orm_usage.orm_usage.Repository.DO.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAll();

}
