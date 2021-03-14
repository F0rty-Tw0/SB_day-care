package com.example.day_care.Model;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;

@Entity
public class Group {
    @Id
    private int grpId;

    private String grpName;

    public String getGrpName() {
        return grpName;
    }

    public void setGrpName(String grpName) {
        this.grpName = grpName;
    }

    public void setGrpId(int grpId) {
        this.grpId = grpId;
    }

    @javax.persistence.Id
    public int getGrpId() {
        return grpId;
    }
}
