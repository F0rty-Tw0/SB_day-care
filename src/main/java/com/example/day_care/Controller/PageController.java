package com.example.day_care.Controller;

import javax.servlet.http.HttpSession;

import com.example.day_care.Model.Employee;
import com.example.day_care.Service.EmployeeService.InterfaceEmployeeService;
import com.example.day_care.Service.LoginService.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {
    @Autowired
    private Environment environment;
    @Autowired
    private InterfaceEmployeeService interfaceEmployeeService;

    @GetMapping("/")
    public String Index(Model model) {
        return "home/index";
    }

    @PostMapping("/")
    public String adminLogOut(HttpSession session) {
        session.setAttribute("isValidated", false);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(Model model, HttpSession session) {
        LoginService login = new LoginService();
        session.setAttribute("wrongCredentials", false);
        model.addAttribute("myLogin", login);
        return "login/login";
    }

    @PostMapping("/login")
    public String loginPost(@ModelAttribute("myLogin") LoginService myLogin, HttpSession session) {
        String adminUsername = environment.getProperty("admin.userName");
        String adminPassword = environment.getProperty("admin.userPassword");
        myLogin.setValidated(adminUsername, adminPassword);
        if (myLogin.isValidated()) {
            Employee admin = interfaceEmployeeService.findEmployeeByRole("admin");
            session.setAttribute("isValidated", true);
            session.setAttribute("admin", admin);
            return "redirect:/admin";
        } else {
            session.setAttribute("isValidated", false);
            session.setAttribute("wrongCredentials", true);
            return "login/login";
        }
    }

    @GetMapping("/admin")
    public String displayAdmin(Model model, HttpSession session) {
        if (session.getAttribute("isValidated") != null && session.getAttribute("isValidated").equals(true)) {
            return "admin/admin";
        } else {
            return "redirect:/login";
        }
    }
}
