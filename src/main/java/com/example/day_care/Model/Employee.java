package com.example.day_care.Model;

import org.springframework.data.annotation.Id;
import javax.persistence.Entity;

@Entity
public class Employee {
    @Id
    private int empId;
    private String empName;
    private String empSchedule;
    private long empPhoneNr;
    private String empRole;
    private int empGrpId;

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpSchedule() {
        return empSchedule;
    }

    public void setEmpSchedule(String empSchedule) {
        this.empSchedule = empSchedule;
    }

    public long getEmpPhoneNr() {
        return empPhoneNr;
    }

    public void setEmpPhoneNr(long empPhoneNr) {
        this.empPhoneNr = empPhoneNr;
    }

    public String getEmpRole() {
        return empRole;
    }

    public void setEmpRole(String empRole) {
        this.empRole = empRole;
    }

    public int getEmpGrpId() {
        return empGrpId;
    }

    public void setEmpGrpId(int empGrpId) {
        this.empGrpId = empGrpId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    @javax.persistence.Id
    public int getEmpId() {
        return empId;
    }
}
