package com.example.day_care.Model;

public abstract class Employee {
    private String role;
    private String name;
    private long phoneNumber;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // R - VIEW
    abstract public void viewParents();

    abstract public void viewChildren();

    abstract public void viewGroups();

    abstract public void viewSchedule();
}
