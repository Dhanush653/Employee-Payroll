package com.bridgelabz.employeepayrollapp1.controller;

import java.util.List;

import com.bridgelabz.employeepayrollapp1.entity.Employeedetails;
import com.bridgelabz.employeepayrollapp1.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    //localhost:8080/employees
    @GetMapping("/employees")
    public List<Employeedetails> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    //localhost:8080/employee/id
    @GetMapping("/employee/{id}")
    public Employeedetails getEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }
    //localhost:8080/employee/add
    @PostMapping("/employee/add")
    public Employeedetails addEmployee(@RequestBody Employeedetails employee){
        return employeeService.addEmployee(employee);
    }
    //localhost:8080/employee/update/id
    @PutMapping("/employee/update/{id}")
    public Employeedetails updateEmployee(@PathVariable int id){
        return employeeService.updateEmployee(id);
    }
    //localhost:8080/employee/delete/idi
    @DeleteMapping("/employee/delete/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
    }
}
