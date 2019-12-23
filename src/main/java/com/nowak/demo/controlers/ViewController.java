package com.nowak.demo.controlers;

import com.nowak.demo.models.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String getLandingPage(){
        return "index";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("userModel",new UserModel());
        return "login-form";
    }

    @GetMapping("/home")
    public String getHomePage(){
        return "main";
    }
}
