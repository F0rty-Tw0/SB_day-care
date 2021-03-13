package com.example.day_care.Model;

public abstract class Administrator extends Employee {
    private String password;
    private String login;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // C - ADD
    abstract public void addEmployee();

    abstract public void addSchedule();

    abstract public void addParrent();

    abstract public void addChild();

    abstract public void addGroup();

    // R - VIEW - implements from Employee

    // U - EDIT
    abstract public void editEmployee();

    abstract public void editSchedule();

    abstract public void editParrent();

    abstract public void editChild();

    abstract public void editGroup();

    // D - DELETE
    abstract public void deleteEmployee();

    abstract public void deleteSchedule();

    abstract public void deleteParrent();

    abstract public void dleteChild();

    abstract public void deleteGroup();
}