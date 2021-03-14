package com.example.day_care.Controller;

import com.example.day_care.Model.Kid;
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
    // Admin state
    private boolean isValidated;

    @GetMapping("/error")
    public String Error() {
        return "error";
    }

    @GetMapping("/")
    public String Index(Model model) {
        Kid kid = new Kid();

        model.addAttribute("myKid", kid);
        // jdbcTemplate.execute("ALTER TABLE kids ADD COLUMN kidGrpId VARCHAR(15) AFTER
        // kidName");
        // kid.setKidAge(13);
        // kid.setKidName("Juan");
        // jdbcTemplate.update("INSERT INTO kids(kidAge, kidName) VALUES (?,?)",
        // kid.getKidAge(), kid.getKidName());

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
        myLogin.setValidated(environment.getProperty("admin.userName"), environment.getProperty("admin.userPassword"));

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
