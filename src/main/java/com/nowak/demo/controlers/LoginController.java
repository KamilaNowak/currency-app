package com.nowak.demo.controlers;

import com.nowak.demo.entities.User;
import com.nowak.demo.models.UserModel;
import com.nowak.demo.service.UserService;
import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LoginController {


    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserService userService;

    @Autowired
    public LoginController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping("/register")
    public String processLogin(@ModelAttribute("userModel") UserModel userModel, BindingResult bindingResult) {
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
            userService.save(newUser);
        }
        return "login-form";
    }
}
