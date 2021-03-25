package com.example.day_care.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.day_care.Model.Employee;
import com.example.day_care.Model.Schedule;

import com.example.day_care.Service.EmployeeService.InterfaceEmployeeService;
import com.example.day_care.Service.GroupService.InterfaceGroupService;
import com.example.day_care.Service.ScheduleService.InterfaceScheduleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
  @Autowired
  private InterfaceGroupService interfaceGroupService;
  @Autowired
  private InterfaceScheduleService interfaceScheduleService;
  @Autowired
  private InterfaceEmployeeService interfaceEmployeeService;

  @GetMapping("/employees")
  public String displayEmployees(Model model, HttpSession session) {
    List<Employee> employeesList = interfaceEmployeeService.viewAllEmployees();
    List<Schedule> scheduleList = interfaceScheduleService.viewAllSchedules();
    model.addAttribute("interfaceScheduleService", interfaceScheduleService);
    model.addAttribute("interfaceGroupService", interfaceGroupService);
    model.addAttribute("mySchedule", scheduleList);
    model.addAttribute("myEmployees", employeesList);
    return "employees/employees";
  }

  @PostMapping("/employees")
  public String addNewEmployee(@ModelAttribute Employee employee) {
    System.out.println(employee.getEmpName());
    System.out.println(employee.getEmpSchId());
    System.out.println(employee.getEmpPhoneNr());
    System.out.println(employee.getEmpRole());
    System.out.println(employee.getEmpGrpId());
    return "redirect:/employees";
  }

  @PostMapping("/editEmployee")
  public String editEmployee(@ModelAttribute Employee employee) {
    System.out.println(employee.getEmpId());
    System.out.println(employee.getEmpName());
    System.out.println(employee.getEmpSchId());
    System.out.println(employee.getEmpPhoneNr());
    System.out.println(employee.getEmpRole());
    System.out.println(employee.getEmpGrpId());
    return "redirect:/employees";
  }

  @PostMapping("/deleteEmployee")
  public String deleteEmployee(@ModelAttribute Employee employee) {
    System.out.println(employee.getEmpId());
    return "redirect:/employees";
  }
}
