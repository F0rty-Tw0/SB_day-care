package com.example.day_care.Service.ScheduleService;

import java.util.List;

import com.example.day_care.Model.Schedule;

public interface InterfaceScheduleService {

  // CREATE
  public Schedule addSchedule(Schedule mySchedule);

  // READ
  public Schedule findScheduleById(int schId);

  public List<Schedule> viewAllSchedules();

  // UPDATE
  public Schedule editSchedule(int schId, Schedule mySchedule);

  // DELETE
  public boolean deleteSchedule(int schId);

}
