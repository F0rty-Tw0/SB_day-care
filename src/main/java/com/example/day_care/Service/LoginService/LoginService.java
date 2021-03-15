package com.example.day_care.Service.LoginService;

public class LoginService {
    public String inputUserName;
    public String inputUserPassword;
    private boolean validated;

    public String getInputUserName() {
        return inputUserName;
    }

    public String getInputUserPassword() {
        return inputUserPassword;
    }

    public void setInputUserName(String inputUserName) {
        this.inputUserName = inputUserName;
    }

    public void setInputUserPassword(String inputUserPassword) {
        this.inputUserPassword = inputUserPassword;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(String envUserName, String envUserPassword) {
        if (getInputUserName().equals(envUserName) && getInputUserPassword().equals(envUserPassword)) {
            this.validated = true;
        }
    }
}
