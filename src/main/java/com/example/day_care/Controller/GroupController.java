
package com.example.day_care.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.day_care.Model.Group;

import com.example.day_care.Service.EmployeeService.InterfaceEmployeeService;
import com.example.day_care.Service.GroupService.InterfaceGroupService;
import com.example.day_care.Service.KidService.InterfaceKidService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GroupController {
  @Autowired
  private InterfaceKidService interfaceKidService;

  @Autowired
  private InterfaceGroupService interfaceGroupService;

  @Autowired
  private InterfaceEmployeeService interfaceEmployeeService;

  @GetMapping("/groups")
  public String displayGroups(Model model, HttpSession session) {
    List<Group> groupsList = interfaceGroupService.viewAllGroups();
    model.addAttribute("interfaceEmployeeService", interfaceEmployeeService);
    model.addAttribute("interfaceKidService", interfaceKidService);
    model.addAttribute("myGroups", groupsList);
    return "groups/groups";
  }

  @PostMapping("/groups")
  public String addNewGroup(@ModelAttribute Group group) {
    System.out.println(group.getGrpName());
    return "redirect:/groups";
  }

  @PostMapping("/editGroup")
  public String editGroup(@ModelAttribute Group group) {
    System.out.println(group.getGrpId());
    System.out.println(group.getGrpName());
    return "redirect:/groups";
  }

  @PostMapping("/deleteGroup")
  public String deleteGroup(@ModelAttribute Group group) {
    System.out.println(group.getGrpId());
    return "redirect:/groups";
  }

}
