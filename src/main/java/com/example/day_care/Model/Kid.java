package com.example.day_care.Model;

import org.springframework.data.annotation.Id;
import javax.persistence.Entity;

@Entity
public class Kid {
    @Id
    private int kidId;
    private String kidName;
    private int kidAge;
    private int kidParentId;
    private int kidGrpId;

    public Kid() {
    }

    public Kid(int kidAge, String kidName) {
        this.kidAge = kidAge;
        this.kidName = kidName;
    }

    public String getKidName() {
        return kidName;
    }

    public void setKidName(String kidName) {
        this.kidName = kidName;
    }

    public int getKidAge() {
        return kidAge;
    }

    public void setKidAge(int kidAge) {
        this.kidAge = kidAge;
    }

    public int getKidParentId() {
        return kidParentId;
    }

    public void setKidParentId(int kidParentId) {
        this.kidParentId = kidParentId;
    }

    public int getKidGrpId() {
        return kidGrpId;
    }

    public void setKidGrpId(int kidGrpId) {
        this.kidGrpId = kidGrpId;
    }

    public void setKidId(int kidId) {
        this.kidId = kidId;
    }

    @javax.persistence.Id
    public int getKidId() {
        return kidId;
    }
}
