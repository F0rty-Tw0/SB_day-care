package com.example.day_care.Repository.EmployeeRepository;

import java.util.List;

import com.example.day_care.Model.Employee;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeCRUD implements InterfaceEmployee {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // CREATE
    @Override
    public Employee addEmployee(Employee myEmployee) {
        String sql = "INSERT INTO employees(empName, empSchedule, empPhoneNr, empRole) VALUES(?,?,?,?)";
        jdbcTemplate.update(sql, myEmployee.getEmpName(), myEmployee.getEmpSchedule(), myEmployee.getEmpPhoneNr(),
                myEmployee.getEmpRole());
        return null;
    };

    // READ
    @Override
    public Employee findEmployeeById(int empId) {
        String sql = "SELECT * FROM employees WHERE empId=?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        Employee myEmployee = jdbcTemplate.queryForObject(sql, rowMapper, empId);
        return myEmployee;
    };

    public List<Employee> viewAllEmployees() {
        String sql = "SELECT * FROM employees";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        return jdbcTemplate.query(sql, rowMapper);
    };

    // UPDATE
    @Override
    public Employee editEmployee(int empId, Employee myEmployee) {
        return null;
    };

    // DELETE
    @Override
    public boolean deleteEmployee(int empId) {
        String sql = "DELETE FROM employees WHERE empId=?";
        return jdbcTemplate.update(sql, empId) >= 0;
    };

}
