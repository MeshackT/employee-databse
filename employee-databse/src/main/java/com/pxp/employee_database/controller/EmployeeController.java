package com.pxp.employee_database.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pxp.employee_database.entity.EmployeeEntity;
import com.pxp.employee_database.model.Employees;
import com.pxp.employee_database.service.EmployeeService;

@RestController
@CrossOrigin("*")
@RequestMapping("api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
    // Get all employees
    @GetMapping("/get-all")
    public List<Employees> getAllEmployees() {
        return employeeService.getAllEmployees();        
    }
    
    // Add a new employee
    @PostMapping("/add")
    public String addEmployee(@RequestBody EmployeeEntity employee) {
        return employeeService.addEmployee(employee);        
    }

    // Update an employee
    @PutMapping("/update")
    public String updateEmployee(@RequestBody EmployeeEntity employee) {
        return employeeService.updateEmployee(employee);
    }
    
    // Delete an employee by ID
    @DeleteMapping("/delete/{id}")
    public String removeEmployee(@PathVariable int id) {
        EmployeeEntity employee = new EmployeeEntity();
        employee.setId(id);  // Set only the ID for deletion
        return employeeService.removeEmployee(employee);
    }
}
