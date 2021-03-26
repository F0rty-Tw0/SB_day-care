package com.example.day_care.Repository.ScheduleRepository;

import java.util.List;

import com.example.day_care.Model.Schedule;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ScheduleCRUD implements InterfaceSchedule {

  @Autowired
  JdbcTemplate jdbcTemplate;

  // CREATE
  @Override
  public Schedule addSchedule(Schedule mySchedule) {
    String sql = "INSERT INTO schedules(schTime) VALUES(?)";
    jdbcTemplate.update(sql, mySchedule.getSchTime());
    return null;
  };

  // READ
  @Override
  public Schedule findScheduleById(int schId) {
    String sql = "SELECT * FROM schedules WHERE schId=?";
    RowMapper<Schedule> rowMapper = new BeanPropertyRowMapper<>(Schedule.class);
    Schedule mySchedule = jdbcTemplate.queryForObject(sql, rowMapper, schId);
    return mySchedule;
  };

  @Override
  public List<Schedule> viewAllSchedules() {
    String sql = "SELECT * FROM schedules";
    RowMapper<Schedule> rowMapper = new BeanPropertyRowMapper<>(Schedule.class);
    return jdbcTemplate.query(sql, rowMapper);
  };

  // UPDATE
  @Override
  public Schedule editSchedule(int schId, Schedule mySchedule) {
    String sql = "UPDATE schedules SET schTime WHERE schId=?";
    jdbcTemplate.update(sql, mySchedule.getSchTime(), schId);
    return null;
  };

  // DELETE
  @Override
  public boolean deleteSchedule(int schId) {
    String updateEmp = "UPDATE employees SET empSchId = 1 WHERE empSchId=?";
    String sql = "DELETE FROM schedules WHERE schId=?";
    jdbcTemplate.update(updateEmp, schId);
    return jdbcTemplate.update(sql, schId) >= 0;
  };

}
