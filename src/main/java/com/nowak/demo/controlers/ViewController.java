package com.nowak.demo.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping
    public String getLandingPage(){
        return "index";
    }
    @GetMapping("/login")
    public String getLoginPage(){
        return "login-form";
    }
}
