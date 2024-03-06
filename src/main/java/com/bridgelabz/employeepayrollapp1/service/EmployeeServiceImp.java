package com.bridgelabz.employeepayrollapp1.service;

import com.bridgelabz.employeepayrollapp1.entity.Employeedetails;
import com.bridgelabz.employeepayrollapp1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@Service
public class EmployeeServiceImp implements IEmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employeedetails> getAllEmployees() {
        return employeeRepository.findAll();
    }
    @Override
    public Employeedetails getEmployeeById(int id) {
        Employeedetails employeeOptional = employeeRepository.findById(id).get();
        return employeeOptional;
    }
    @Override
    public Employeedetails addEmployee(Employeedetails employee) {
        return employeeRepository.save(employee);
    }
    @Override
    public Employeedetails updateEmployee(@PathVariable int id){
        Employeedetails employee = employeeRepository.findById(id).get();
        employee.setEmployee_name("Mohamed");
        employee.setEmployee_salary(34500);
        employeeRepository.save(employee);
        return employee;
    }
    @Override
    public void deleteEmployee(@PathVariable int id){
        Employeedetails employee = employeeRepository.findById(id).get();
        employeeRepository.delete(employee);
    }

}
