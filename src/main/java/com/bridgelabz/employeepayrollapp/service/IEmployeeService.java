package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.entity.Employeedetails;

import java.util.List;

public interface IEmployeeService {
    List<EmployeeDTO> getAllEmployees();
    Employeedetails getEmployeeById(int id);
    EmployeeDTO addEmployee(EmployeeDTO employee);
    Employeedetails updateEmployee(int id);
    void deleteEmployee(int id);
}
