package com.example.day_care.Controller;

import java.util.List;
import com.example.day_care.Model.Kid;
import com.example.day_care.Service.KidService.InterfaceKidService;
import com.example.day_care.Service.LoginService.LoginService;
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

    // Admin state
    private boolean isValidated;

    @GetMapping("/error")
    public String Error() {
        return "error";
    }
    // jdbcTemplate.execute("CREATE TABLE kids (" + "kidId SERIAL, kidName VARCHAR(50), kidAge INT)");

    @GetMapping("/")
    public String Index(Model model) {
        List<Kid> kidList = interfaceKidService.viewAllKids();
        model.addAttribute("myKids", kidList);
       
        // Kid kid = new Kid();
        // kid.setKidAge(2);
        // kid.setKidName("Jessica Alba");
        // jdbcTemplate.update("INSERT INTO kids(kidName, kidAge) VALUES (?,?)",
        // kid.getKidName(), kid.getKidAge());

        // String name = "Maria";
        // String sql = "SELECT kidId, kidAge, kidName FROM kids WHERE kidName =
        // \""+name+"\"";
        // List<Kid> listKid = jdbcTemplate.query(sql,
        // BeanPropertyRowMapper.newInstance(Kid.class));

        // listKid.forEach((kids) -> System.out.println(kids.getKidName()));
        return "home/index";
    }

    @GetMapping("/login")
    public String Login(Model model) {
        LoginService login = new LoginService();
        model.addAttribute("myLogin", login);
        return "login/login";
    }

    @PostMapping("/login")
    public String LoginPost(Model model, @ModelAttribute("myLogin") LoginService myLogin) {
        String adminUsername = environment.getProperty("admin.userName");
        String adminPassword = environment.getProperty("admin.userPassword");
        myLogin.setValidated(adminUsername, adminPassword);
        if (myLogin.isValidated()) {
            isValidated = true;
            return "redirect:/admin";
        } else {
            model.addAttribute("wrongCredentials", true);
            return "login/login";
        }
    }

    @GetMapping("/admin")
    public String Admin() {
        if (isValidated) {
            return "admin/admin";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("/admin")
    public String AdminLogOut() {
        isValidated = false;
        return "redirect:/";
    }
}
