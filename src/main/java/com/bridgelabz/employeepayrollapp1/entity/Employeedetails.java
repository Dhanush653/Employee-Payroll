package com.bridgelabz.employeepayrollapp1.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Employeepayrolla")
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
    private LocalDate employee_startdate;
    @Column(name = "gender")
    private String employee_gender;
    @Column(name = "note")
    private String employee_note;

    public Employeedetails() {
    }
    public Employeedetails(int employee_id,String employee_name, String employee_profilepicture, int employee_salary, LocalDate employee_startdate, String employee_gender, String employee_note) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.employee_profilepicture = employee_profilepicture;
        this.employee_salary = employee_salary;
        this.employee_startdate = employee_startdate;
        this.employee_gender = employee_gender;
        this.employee_note = employee_note;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_profilepicture() {
        return employee_profilepicture;
    }

    public void setEmployee_profilepicture(String employee_profilepicture) {
        this.employee_profilepicture = employee_profilepicture;
    }

    public int getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(int employee_salary) {
        this.employee_salary = employee_salary;
    }

    public LocalDate getEmployee_startdate() {
        return employee_startdate;
    }

    public void setEmployee_startdate(LocalDate employee_startdate) {
        this.employee_startdate = employee_startdate;
    }

    public String getEmployee_gender() {
        return employee_gender;
    }

    public void setEmployee_gender(String employee_gender) {
        this.employee_gender = employee_gender;
    }

    public String getEmployee_note() {
        return employee_note;
    }

    public void setEmployee_note(String employee_note) {
        this.employee_note = employee_note;
    }

    @Override
    public String toString() {
        return "Employeedetails{" +
                "employee_id=" + employee_id +
                ", employee_name='" + employee_name + '\'' +
                ", employee_profilepicture='" + employee_profilepicture + '\'' +
                ", employee_salary=" + employee_salary +
                ", employee_startdate=" + employee_startdate +
                ", employee_gender='" + employee_gender + '\'' +
                ", employee_note='" + employee_note + '\'' +
                '}';
    }
}
