package com.bridgelabz.employeepayrollapp1.controller;

import java.util.List;

import com.bridgelabz.employeepayrollapp1.entity.Employeedetails;
import com.bridgelabz.employeepayrollapp1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepository repo;
    //localhost:8080/employees
    @GetMapping("/employees")
    public List<Employeedetails> getAllEmployees(){
        List<Employeedetails> employees = repo.findAll();
        return employees;
    }
    //localhost:8080/employee/id
    @GetMapping("/employee/{id}")
    public Employeedetails getEmployeeById(@PathVariable int id){
        Employeedetails employee = repo.findById(id).get();
        return employee;
    }
    //localhost:8080/employee/add
    @PostMapping("/employee/add")
    public void addEmployee(@RequestBody Employeedetails employee){
        repo.save(employee);
    }
    //localhost:8080/employee/update/id
    @PutMapping("/employee/update/{id}")
    public Employeedetails updateEmployee(@PathVariable int id){
        Employeedetails employee = repo.findById(id).get();
        employee.setEmployee_name("Mohamed");
        employee.setEmployee_salary(34500);
        repo.save(employee);
        return employee;
    }
    //localhost:8080/employee/delete/idi
    @DeleteMapping("/employee/delete/{id}")
    public void deleteEmployee(@PathVariable int id){
        Employeedetails employee = repo.findById(id).get();
        repo.delete(employee);
    }
}
