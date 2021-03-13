package com.example.day_care.Model;

public class Kid {
    private int kidAge;
    private String kidName;

    public Kid() {
    }

    public Kid(int kidAge, String kidName) {
        this.kidAge = kidAge;
        this.kidName = kidName;
    }

    public int getKidAge() {
        return kidAge;
    }

    public void setKidAge(int kidAge) {
        this.kidAge = kidAge;
    }

    public String getKidName() {
        return kidName;
    }

    public void setKidName(String kidName) {
        this.kidName = kidName;
    }
}
