package com.pxp.employee_database.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pxp.employee_database.entity.EmployeeEntity;
import com.pxp.employee_database.model.Employees;
import com.pxp.employee_database.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Get all employees from the DB
    public List<Employees> getAllEmployees() {
        List<EmployeeEntity> employees = employeeRepository.findAll();
        
        List<Employees> customEmployees = new ArrayList<>();
        employees.forEach(e -> {
            Employees employee = new Employees();
            BeanUtils.copyProperties(e, employee);
            customEmployees.add(employee);
        });
        
        return customEmployees;
    }

    // Add the employee to the DB
    public String addEmployee(EmployeeEntity employee) {
        try {
            // Only add if employee does not already exist
            if (!employeeRepository.existsByFirstNameAndLastName(employee.getFirstName(), employee.getLastName())) {
                employeeRepository.save(employee);
                return "Employee added successfully";
            } else {
                return "This employee already exists in the database";
            }
        } catch (Exception e) {
            throw new RuntimeException("Error adding employee: " + e.getMessage(), e);
        }
    }

    // Delete the employee from the DB
    public String removeEmployee(EmployeeEntity employee) {
        try {
            if (employeeRepository.existsById(employee.getId())) {
                employeeRepository.deleteById(employee.getId());
                return "Deleted successfully";
            } else {
                return "This employee does not exist in the database";
            }
        } catch (Exception e) {
            throw new RuntimeException("Error deleting employee: " + e.getMessage(), e);
        }
    }


    // Update the employee
    public String updateEmployee(EmployeeEntity employee) {
        try {
            // Only update if employee exists by ID
            if (employeeRepository.existsById(employee.getId())) {
                employeeRepository.save(employee);
                return "Updated successfully";
            } else {
                return "This employee does not exist in the database";
            }
        } catch (Exception e) {
            throw new RuntimeException("Error updating employee: " + e.getMessage(), e);
        }
    }
}
