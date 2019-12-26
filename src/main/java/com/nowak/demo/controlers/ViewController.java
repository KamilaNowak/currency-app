package com.nowak.demo.controlers;

import com.nowak.demo.entities.User;
import com.nowak.demo.models.UserModel;
import com.nowak.demo.service.UserService;
import com.nowak.demo.sub_service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Arrays;

@Controller
public class ViewController {
    @Autowired
    private  BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private  UserService userService;
    @Autowired
    private SubscriptionService subscriptionService;

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
    public String showHome(){
        return "main";
    }
    @GetMapping("/register")
    public String getHomePage(@Valid @ModelAttribute("userModel") UserModel userModel, BindingResult bindingResult){
        System.out.println("prooocess");
        System.out.println(userModel.getEmail() +" "+ userModel.getPassword()+" "+userModel.getPhonenumber());

        if (bindingResult.hasErrors()) {
            return "login-form";
        }
        User user = null;
        user = userService.findByEmail(userModel.getEmail());
        if (user != null) {
            return "login-form";
        } else {
            User newUser = new User();
            newUser.setEmail(userModel.getEmail());
            newUser.setPassword(bCryptPasswordEncoder.encode(userModel.getPassword()));
            newUser.setPhoneNumber(userModel.getPhonenumber());
            newUser.setSubscriptionCollection(Arrays.asList(subscriptionService.findBySubscription("ROLE_STANDARD")));
            userService.save(newUser);
        }
        return "login-form";
    }
}
