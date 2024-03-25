package com.bridgelabz.employeepayrollapp1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDTO {
    private String name;
    private String profileimage;
    private String gender;
    private String department;
    private int salary;
    private String startdate;
    private String notes;
}
