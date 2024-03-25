package com.bridgelabz.employeepayrollapp1.service;

import com.bridgelabz.employeepayrollapp1.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp1.entity.Employeedetails;

import java.util.List;

public interface IEmployeeService {
    List<EmployeeDTO> getAllEmployees();
    Employeedetails getEmployeeById(int id);
    Employeedetails addEmployee(Employeedetails employee);
    Employeedetails updateEmployee(int id);
    void deleteEmployee(int id);
}
