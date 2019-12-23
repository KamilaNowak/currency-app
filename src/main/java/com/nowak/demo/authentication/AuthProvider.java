package com.nowak.demo.authentication;

import com.nowak.demo.entities.User;
import com.nowak.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class AuthProvider implements AuthenticationSuccessHandler {

    private final UserService userService;

    public AuthProvider(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        String email = authentication.getName();
        User user = null;
        try{
            user = userService.findByEmail(email);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        HttpSession httpSession = httpServletRequest.getSession();
        httpSession.setAttribute("user",user);
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/home");
    }
}
