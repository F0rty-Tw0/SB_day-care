package com.example.day_care.Service.LoginService;

public class LoginService {
    private String userName;
    private String userPassword;
    private boolean validated;

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(String envUserName, String envUserPassword) {
        if (userName.equals(envUserName) && userPassword.equals(envUserPassword)) {
            this.validated = true;
        }
    }
}
