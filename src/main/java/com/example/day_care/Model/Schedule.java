package com.example.day_care.Model;

import org.springframework.data.annotation.Id;
import javax.persistence.Entity;

@Entity
public class Schedule {
  @Id
  String schId;
  String schTime;

  public String getSchTime() {
    return schTime;
  }

  public void setSchTime(String schTime) {
    this.schTime = schTime;
  }

  @javax.persistence.Id
  public String getSchId() {
    return schId;
  }

  public void setSchId(String schId) {
    this.schId = schId;
  }
}
