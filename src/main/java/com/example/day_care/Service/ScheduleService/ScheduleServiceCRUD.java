package com.example.day_care.Service.ScheduleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.day_care.Model.Schedule;
import com.example.day_care.Repository.ScheduleRepository.InterfaceSchedule;

@Service
public class ScheduleServiceCRUD implements InterfaceScheduleService {

  @Autowired
  InterfaceSchedule interfaceSchedule;

  // CREATE
  @Override
  public Schedule addSchedule(Schedule mySchedule) {
    return interfaceSchedule.addSchedule(mySchedule);
  };

  // READ
  @Override
  public Schedule findScheduleById(int schId) {
    return interfaceSchedule.findScheduleById(schId);
  };

  @Override
  public List<Schedule> viewAllSchedules() {
    return interfaceSchedule.viewAllSchedules();
  };

  // UPDATE
  @Override
  public Schedule editSchedule(int schId, Schedule mySchedule) {
    return interfaceSchedule.editSchedule(schId, mySchedule);
  };

  // DELETE
  @Override
  public boolean deleteSchedule(int schId) {
    return interfaceSchedule.deleteSchedule(schId);
  };
}
