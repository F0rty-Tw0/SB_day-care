package com.example.day_care.Controller;

import com.example.day_care.Model.Kid;
import org.springframework.stereotype.Controller;
import org.springframework.core.env.Environment;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

@Controller
public class HomeController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    private Environment environment;
    @GetMapping("/")
    public String showForm(Model model) {
        Kid kid = new Kid();
        model.addAttribute("myKid", kid);
        // jdbcTemplate.execute("ALTER TABLE kids ADD COLUMN kidGrpId VARCHAR(15) AFTER kidName");
        
        System.out.println(environment.getProperty("admin.password"));
        // kid.setKidAge(13);
        // kid.setKidName("Juan");
        // jdbcTemplate.update("INSERT INTO kids(kidAge, kidName) VALUES (?,?)", kid.getKidAge(), kid.getKidName());

        // String name = "Maria";
        // String sql = "SELECT kidId, kidAge, kidName FROM kids WHERE kidName =
        // \""+name+"\"";
        // List<Kid> listKid = jdbcTemplate.query(sql,
        // BeanPropertyRowMapper.newInstance(Kid.class));

        // listKid.forEach((kids) -> System.out.println(kids.getKidName()));
        return "home/index";
    }

}
