package com.gopnik.orm_usage.orm_usage.Repository;

import com.gopnik.orm_usage.orm_usage.Repository.DO.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager,Long> {


}
