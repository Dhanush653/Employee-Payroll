package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.entity.Employeedetails;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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
                        Employeedetails.getEmployee_id(),
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
    public EmployeeDTO getEmployeeById(int id) {
        Employeedetails employee = employeeRepository.findById(id).get();
        // Map entity fields to DTO fields
        EmployeeDTO employeeDTO = new EmployeeDTO(
                employee.getEmployee_id(),
                employee.getEmployee_name(),
                employee.getEmployee_profilepicture(),
                employee.getEmployee_gender(),
                Arrays.asList(employee.getEmployee_department()), // Assuming a single department as a String
                employee.getEmployee_salary(),
                employee.getEmployee_startdate(),
                employee.getEmployee_note()
        );
        return employeeDTO;
    }

    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        Employeedetails employee = new Employeedetails();
        employee.setEmployee_name(employeeDTO.getName());
        employee.setEmployee_profilepicture(employeeDTO.getProfileimage());
        employee.setEmployee_gender(employeeDTO.getGender());
        String department = String.join(",", employeeDTO.getDepartment());
        employee.setEmployee_department(department);
        employee.setEmployee_salary(employeeDTO.getSalary());
        employee.setEmployee_startdate(employeeDTO.getStartdate());
        employee.setEmployee_note(employeeDTO.getNotes());
        Employeedetails savedEmployee = employeeRepository.save(employee);
        return new EmployeeDTO(
                savedEmployee.getEmployee_id(),
                savedEmployee.getEmployee_name(),
                savedEmployee.getEmployee_profilepicture(),
                savedEmployee.getEmployee_gender(),
                Arrays.asList(savedEmployee.getEmployee_department().split(",")),
                savedEmployee.getEmployee_salary(),
                savedEmployee.getEmployee_startdate(),
                savedEmployee.getEmployee_note()
        );
    }


//    public Employeedetails updateEmployee(int id, EmployeeDTO empDTO){
//        Optional<Employeedetails> data = employeeRepository.findById(id);
//        if(data.isPresent()){
//            data.get().setEmployee_name(empDTO.getName());
//            data.get().setEmployee_profilepicture(empDTO.getProfileimage());
//            data.get().setEmployee_salary(empDTO.getSalary());
//            data.get().setEmployee_startdate(empDTO.getStartdate());
//            data.get().setEmployee_gender(empDTO.getGender());
//            data.get().setEmployee_note(empDTO.getNotes());
//            data.get().setEmployee_department(String.valueOf(empDTO.getDepartment()));
//            return employeeRepository.save(data.get());
//        }
//        return null;
//    }
@Override
public EmployeeDTO updateEmployee(int id, EmployeeDTO empDTO) {
    Optional<Employeedetails> employeeOptional = employeeRepository.findById(id);
    if (employeeOptional.isPresent()) {
        Employeedetails employee = employeeOptional.get();

        // Update fields from DTO to entity
        employee.setEmployee_name(empDTO.getName());
        employee.setEmployee_profilepicture(empDTO.getProfileimage());
        employee.setEmployee_salary(empDTO.getSalary());
        employee.setEmployee_startdate(empDTO.getStartdate());
        employee.setEmployee_gender(empDTO.getGender());
        employee.setEmployee_note(empDTO.getNotes());
        employee.setEmployee_department(String.valueOf(empDTO.getDepartment().get(0))); // Assuming first department

        // Save updated entity
        Employeedetails savedEmployee = employeeRepository.save(employee);

        // Create and return updated DTO
        return new EmployeeDTO(
                savedEmployee.getEmployee_id(),
                savedEmployee.getEmployee_name(),
                savedEmployee.getEmployee_profilepicture(),
                savedEmployee.getEmployee_gender(),
                Arrays.asList(savedEmployee.getEmployee_department()), // Convert back to List for DTO
                savedEmployee.getEmployee_salary(),
                savedEmployee.getEmployee_startdate(),
                savedEmployee.getEmployee_note()
        );
    }
    return null;
}

    @Override
    public void deleteEmployee(int id){
        Employeedetails employee = employeeRepository.findById(id).get();
        employeeRepository.delete(employee);
    }

}
