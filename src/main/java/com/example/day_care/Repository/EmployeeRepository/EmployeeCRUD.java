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
        String sql = "INSERT INTO employees(empName, empSchId, empPhoneNr, empRole, empGrpId) VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, myEmployee.getEmpName(), myEmployee.getEmpSchId(), myEmployee.getEmpPhoneNr(),
                myEmployee.getEmpRole(), myEmployee.getEmpGrpId());
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

    @Override
    public Employee findEmployeeByRole(String empRole) {
        String sql = "SELECT * FROM employees WHERE empRole=?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        Employee myEmployee = new Employee();
        try {
            myEmployee = jdbcTemplate.queryForObject(sql, rowMapper, empRole);
        } catch (Exception e) {
            System.out.println("Error occured: " + e);
        }
        return myEmployee;
    };

    @Override
    public List<Employee> findEmployeeByGrpId(int empGrpId) {
        String sql = "SELECT * FROM employees WHERE empGrpId=?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        return jdbcTemplate.query(sql, rowMapper, empGrpId);
    };

    @Override
    public List<Employee> viewAllEmployees() {
        String sql = "SELECT * FROM employees";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        return jdbcTemplate.query(sql, rowMapper);
    };

    // UPDATE
    @Override
    public Employee editEmployee(int empId, Employee myEmployee) {
        String sql = "UPDATE employees SET empName=?, empSchId=?, empPhoneNr=?, empRole=?, empGrpId=? WHERE empId=?";
        jdbcTemplate.update(sql, myEmployee.getEmpName(), myEmployee.getEmpSchId(), myEmployee.getEmpPhoneNr(),
                myEmployee.getEmpRole(), myEmployee.getEmpGrpId(), empId);
        return null;
    };

    // DELETE
    @Override
    public boolean deleteEmployee(int empId) {
        String sql = "DELETE FROM employees WHERE empId=?";
        return jdbcTemplate.update(sql, empId) >= 0;
    };

}
