package com.gopnik.orm_usage.orm_usage.Repository.DO;

import jakarta.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "employee")
@Getter
@Setter
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double salary;

    @ManyToOne(cascade = CascadeType.PERSIST) //This will create a new manager if it does not exist.
    @JoinColumn(name = "manager_id")
    private Manager manager;
}
