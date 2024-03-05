package com.bridgelabz.employeepayrollapp1.repository;

import com.bridgelabz.employeepayrollapp1.entity.Employeedetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employeedetails, Integer> {
}
