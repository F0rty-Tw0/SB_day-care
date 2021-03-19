package com.example.day_care.Service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.day_care.Model.Employee;
import com.example.day_care.Repository.EmployeeRepository.InterfaceEmployee;

@Service
public class EmployeeServiceCRUD implements InterfaceEmployeeService {
    @Autowired
    InterfaceEmployee interfaceEmployee;

    // CREATE
    @Override
    public Employee addEmployee(Employee myEmployee) {
        return interfaceEmployee.addEmployee(myEmployee);
    };

    // READ
    @Override
    public Employee findEmployeeById(int empId) {
        return interfaceEmployee.findEmployeeById(empId);
    };

    @Override
    public List<Employee> findEmployeeByGrpId(int empGrpId) {
        return interfaceEmployee.findEmployeeByGrpId(empGrpId);
    };

    @Override
    public List<Employee> viewAllEmployees() {
        return interfaceEmployee.viewAllEmployees();
    };

    // UPDATE
    @Override
    public Employee editEmployee(int empId, Employee myEmployee) {
        return interfaceEmployee.editEmployee(empId, myEmployee);
    };

    // DELETE
    @Override
    public boolean deleteEmployee(int empId) {
        return interfaceEmployee.deleteEmployee(empId);
    };
}
