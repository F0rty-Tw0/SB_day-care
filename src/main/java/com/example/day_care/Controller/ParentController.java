package com.example.day_care.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.day_care.Model.Parent;
import com.example.day_care.Service.KidService.InterfaceKidService;
import com.example.day_care.Service.ParentService.InterfaceParentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ParentController {

  @Autowired
  private InterfaceKidService interfaceKidService;
  @Autowired
  private InterfaceParentService interfaceParentService;

  @GetMapping("/parents")
  public String displayParents(Model model, HttpSession session) {
    List<Parent> parentsList = interfaceParentService.viewAllParents();
    model.addAttribute("interfaceKidService", interfaceKidService);
    model.addAttribute("myParents", parentsList);
    return "parents/parents";
  }

  @PostMapping("/editParent")
  public String editParent(@ModelAttribute Parent parent) {
    interfaceParentService.editParent(parent.getParentId(), parent);
    return "redirect:/parents";
  }

  @PostMapping("/deleteParent")
  public String deleteParent(@ModelAttribute Parent parent) {
    interfaceParentService.deleteParent(parent.getParentId());
    return "redirect:/parents";
  }

  @PostMapping("/admin")
  public String submitAdminForm(Model model, @ModelAttribute Parent parent, HttpSession session) {
    interfaceParentService.addParent(parent);
    model.addAttribute("lastParent", interfaceParentService.sellectLastParent().getParentId());
    return "admin/addKid";
  }

}
