package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.entity.Employeedetails;

import java.util.List;

public interface IEmployeeService {
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(int id);
    EmployeeDTO addEmployee(EmployeeDTO employee);
    EmployeeDTO updateEmployee(int id, EmployeeDTO empDTO);
    void deleteEmployee(int id);
}
