package com.gopnik.orm_usage.orm_usage.Repository;

import com.gopnik.orm_usage.orm_usage.Repository.DO.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    List<Employee> findAll();

    @Query("SELECT e FROM employee e WHERE e.salary > :updatedSalaryGte")
    List<Employee> findHighSalaryEmployees(@Param("updatedSalaryGte") Double updatedSalaryGte);

}
