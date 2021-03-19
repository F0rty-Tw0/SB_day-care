package com.example.day_care.Service.EmployeeService;

import java.util.List;

import com.example.day_care.Model.Employee;

public interface InterfaceEmployeeService {

    // CREATE
    public Employee addEmployee(Employee myEmployee);

    // READ
    public Employee findEmployeeById(int empId);

    public List<Employee> findEmployeeByGrpId(int empGrpId);
    
    public List<Employee> viewAllEmployees();

    // UPDATE
    public Employee editEmployee(int empId, Employee myEmployee);

    // DELETE
    public boolean deleteEmployee(int empId);
}
