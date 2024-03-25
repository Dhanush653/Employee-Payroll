package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.entity.Employeedetails;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
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
                        Arrays.asList(Employeedetails.getEmployee_department().split(",")),
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
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        Employeedetails employee = new Employeedetails();
        employee.setEmployee_name(employeeDTO.getName());
        employee.setEmployee_profilepicture(employeeDTO.getProfileimage());
        employee.setEmployee_gender(employeeDTO.getGender());
        // Convert the List<String> department to a comma-separated string
        String department = String.join(",", employeeDTO.getDepartment());
        employee.setEmployee_department(department);
        employee.setEmployee_salary(employeeDTO.getSalary());
        employee.setEmployee_startdate(employeeDTO.getStartdate());
        employee.setEmployee_note(employeeDTO.getNotes());
        Employeedetails savedEmployee = employeeRepository.save(employee);
        return new EmployeeDTO(
                savedEmployee.getEmployee_name(),
                savedEmployee.getEmployee_profilepicture(),
                savedEmployee.getEmployee_gender(),
                // Split the department string back into a List<String>
                Arrays.asList(savedEmployee.getEmployee_department().split(",")),
                savedEmployee.getEmployee_salary(),
                savedEmployee.getEmployee_startdate(),
                savedEmployee.getEmployee_note()
        );
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
