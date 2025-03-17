package com.gopnik.orm_usage.orm_usage.Repository.DO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "employee")
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double salary;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;
}
