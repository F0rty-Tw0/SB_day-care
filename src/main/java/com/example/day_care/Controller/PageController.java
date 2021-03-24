package com.example.day_care.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.day_care.Model.Employee;
import com.example.day_care.Model.Group;
import com.example.day_care.Model.Kid;
import com.example.day_care.Model.Parent;
import com.example.day_care.Model.Schedule;
import com.example.day_care.Service.EmployeeService.InterfaceEmployeeService;
import com.example.day_care.Service.GroupService.InterfaceGroupService;
import com.example.day_care.Service.KidService.InterfaceKidService;
import com.example.day_care.Service.LoginService.LoginService;
import com.example.day_care.Service.ParentService.InterfaceParentService;
import com.example.day_care.Service.ScheduleService.InterfaceScheduleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    private Environment environment;
    @Autowired
    private InterfaceKidService interfaceKidService;
    @Autowired
    private InterfaceParentService interfaceParentService;
    @Autowired
    private InterfaceGroupService interfaceGroupService;
    @Autowired
    private InterfaceScheduleService interfaceScheduleService;
    @Autowired
    private InterfaceEmployeeService interfaceEmployeeService;

    // Admin state
    private boolean isValidated;

    @GetMapping("/")
    public String Index(Model model, HttpSession session) {
        session.setAttribute("isValidated", isValidated);
        return "home/index";
    }

    @PostMapping("/")
    public String adminLogOut() {
        isValidated = false;
        return "redirect:/";
    }

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

    @GetMapping("/parents")
    public String displayParents(Model model, HttpSession session) {
        List<Parent> parentsList = interfaceParentService.viewAllParents();
        model.addAttribute("interfaceKidService", interfaceKidService);
        model.addAttribute("myParents", parentsList);
        return "parents/parents";
    }

    @GetMapping("/groups")
    public String displayGroups(Model model, HttpSession session) {
        List<Group> groupsList = interfaceGroupService.viewAllGroups();
        model.addAttribute("interfaceEmployeeService", interfaceEmployeeService);
        model.addAttribute("interfaceKidService", interfaceKidService);
        model.addAttribute("myGroups", groupsList);
        return "groups/groups";
    }

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

    @GetMapping("/login")
    public String login(Model model, HttpSession session) {
        LoginService login = new LoginService();
        model.addAttribute("myLogin", login);
        return "login/login";
    }

    @PostMapping("/login")
    public String loginPost(Model model, @ModelAttribute("myLogin") LoginService myLogin, HttpSession session) {
        String adminUsername = environment.getProperty("admin.userName");
        String adminPassword = environment.getProperty("admin.userPassword");
        myLogin.setValidated(adminUsername, adminPassword);
        if (myLogin.isValidated()) {
            isValidated = true;
            Employee admin = interfaceEmployeeService.findEmployeeByRole("admin");
            session.setAttribute("isValidated", isValidated);
            session.setAttribute("admin", admin);
            return "redirect:/admin";
        } else {
            isValidated = false;
            model.addAttribute("wrongCredentials", true);
            return "login/login";
        }
    }

    @GetMapping("/admin")
    public String displayAdmin(Model model, HttpSession session) {
        if (isValidated) {
            return "admin/admin";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("/admin")
    public String submitAdminForm(Model model, HttpSession session) {
        return "admin/addKid";
    }

    @PostMapping("/addKid")
    public String addNewKidForm(Model model, HttpSession session) {
        return "admin/addKid";
    }
    @PostMapping("/success")
    public String addNewParentForm(Model model, HttpSession session) {
        return "admin/success";
    }
}
