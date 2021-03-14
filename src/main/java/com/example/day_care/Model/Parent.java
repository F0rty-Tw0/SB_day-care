package com.example.day_care.Model;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;

@Entity
public class Parent {
    @Id
    private int parentId;
    private String momName;
    private String dadName;
    private int phoneNumber;
    private String address;

    public String getMomName() {
        return momName;
    }

    public void setMomName(String momName) {
        this.momName = momName;
    }

    public String getDadName() {
        return dadName;
    }

    public void setDadName(String dadName) {
        this.dadName = dadName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @javax.persistence.Id
    public int getParentId() {
        return parentId;
    }
}
