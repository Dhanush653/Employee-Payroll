package com.bridgelabz.employeepayrollapp1.service;

import com.bridgelabz.employeepayrollapp1.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp1.entity.Employeedetails;
import com.bridgelabz.employeepayrollapp1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImp implements IEmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository; 

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeDTO> allemployee = employeeRepository.findAll()
                .stream()
                .map(Employeedetails -> new EmployeeDTO(
                        Employeedetails.getEmployee_name(),
                        Employeedetails.getEmployee_profilepicture(),
                        Employeedetails.getEmployee_gender(),
                        Employeedetails.getEmployee_department(),
                        Employeedetails.getEmployee_salary(),
                        Employeedetails.getEmployee_startdate(),
                        Employeedetails.getEmployee_note()
                )).collect(Collectors.toList());
        return allemployee;
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
