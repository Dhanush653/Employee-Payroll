package com.bridgelabz.employeepayrollapp.controller;

import java.util.List;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.entity.Employeedetails;
import com.bridgelabz.employeepayrollapp.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(allowedHeaders = "*")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    //localhost:8080/employees
    @GetMapping("/employees")
    public List<EmployeeDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    //localhost:8080/employee/id
    @GetMapping("/employee/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }
    //localhost:8080/employee/add
    @PostMapping("/employee/add")
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employee){
        return employeeService.addEmployee(employee);
    }

    //localhost:8080/employee/update/id
    @PutMapping("/employee/update/{id}")
    public EmployeeDTO updateEmployee(@PathVariable int id, @RequestBody EmployeeDTO empDTO){
        return employeeService.updateEmployee(id,empDTO);
    }
    //localhost:8080/employee/delete/idi
    @DeleteMapping("/employee/delete/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
    }
}
