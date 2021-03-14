package com.example.day_care.Repository.EmployeeRepository;

import java.util.List;

import com.example.day_care.Model.Employee;

public interface InterfaceEmployee {

    // CREATE
    public Employee addEmployee(Employee myEmployee);

    // READ
    public Employee findEmployeeById(int empId);

    public List<Employee> viewAllEmployees();

    // UPDATE
    public Employee editEmployee(int empId, Employee myEmployee);

    // DELETE
    public boolean deleteEmployee(int empId);

}
