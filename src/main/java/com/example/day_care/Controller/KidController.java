package com.example.day_care.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.day_care.Model.Group;
import com.example.day_care.Model.Kid;
import com.example.day_care.Model.Parent;

import com.example.day_care.Service.GroupService.InterfaceGroupService;
import com.example.day_care.Service.KidService.InterfaceKidService;
import com.example.day_care.Service.ParentService.InterfaceParentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class KidController {
  @Autowired
  private InterfaceKidService interfaceKidService;
  @Autowired
  private InterfaceParentService interfaceParentService;
  @Autowired
  private InterfaceGroupService interfaceGroupService;

  @GetMapping("/children")
  public String displayChildren(Model model, HttpSession session) {
    List<Kid> kidsList = interfaceKidService.viewAllKids();
    List<Group> groupsList = interfaceGroupService.viewAllGroups();
    List<Parent> parentsList = interfaceParentService.viewAllParents();
    model.addAttribute("interfaceGroupService", interfaceGroupService);
    model.addAttribute("interfaceParentService", interfaceParentService);
    model.addAttribute("myParents", parentsList);
    model.addAttribute("myGroups", groupsList);
    model.addAttribute("myKids", kidsList);
    return "children/children";
  }

  @PostMapping("/children")
  public String addNewKid(@ModelAttribute Kid kid) {
    interfaceKidService.addKid(kid);
    return "redirect:/children";
  }

  @PostMapping("/editChildren")
  public String editKid(@ModelAttribute Kid kid) {
    interfaceKidService.editKid(kid.getKidId(), kid);
    return "redirect:/children";
  }

  @PostMapping("/deleteChildren")
  public String deleteKid(@ModelAttribute Kid kid) {
    interfaceKidService.deleteKid(kid.getKidId());
    return "redirect:/children";
  }

  @PostMapping("/addKid")
  public String addNewKidForm(Model model, @ModelAttribute Kid kid) {
    interfaceKidService.addKid(kid);
    model.addAttribute("lastParent", interfaceParentService.sellectLastParent().getParentId());
    return "admin/addKid";
  }

  @PostMapping("/success")
  public String addNewParentForm(@ModelAttribute Kid kid) {
    interfaceKidService.addKid(kid);
    return "admin/success";
  }
}
