package com.nowak.demo.service;

import com.nowak.demo.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends UserDetailsService {

    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;
    User findByEmail(String email);
    void save(User user);
}
