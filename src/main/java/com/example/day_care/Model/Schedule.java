package com.example.day_care.Model;

import org.springframework.data.annotation.Id;
import javax.persistence.Entity;

@Entity
public class Schedule {
  @Id
  int schId;
  String schTime;

  public String getSchTime() {
    return schTime;
  }

  public void setSchTime(String schTime) {
    this.schTime = schTime;
  }

  @javax.persistence.Id
  public int getSchId() {
    return schId;
  }

  public void setSchId(int schId) {
    this.schId = schId;
  }
}
