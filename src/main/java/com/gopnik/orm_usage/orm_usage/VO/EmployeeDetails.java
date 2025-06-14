package com.gopnik.orm_usage.orm_usage.VO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeDetails {

    @NotNull(message = "Employee name cannot be null")
    private String name;

    @NotNull(message = "Salary name cannot be null")
    @Min(value = 10000, message = "Salary must be at least 10,000")
    @Max(value = 200000, message = "Salary must be at most 200,000")
    private Long Salary;

    @NotNull(message = "manager Details cannot be null")
    private ManagerDetails managerDetails;
}
