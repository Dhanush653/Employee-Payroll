package com.bridgelabz.employeepayrollapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Employeepayroll")
public class Employeedetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int employee_id;
    @Column(name = "name")
    private String employee_name;
    @Column(name = "profile")
    private String employee_profilepicture;
    @Column(name = "salary")
    private int employee_salary;
    @Column(name = "start_date")
    private String employee_startdate;
    @Column(name = "gender")
    private String employee_gender;
    @Column(name = "note")
    private String employee_note;
    @Column(name = "department")
    private String employee_department;
}
