package com.nowak.demo.userdetails;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetails implements  UserDetailsService {
    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String s)
            throws UsernameNotFoundException {
        return null;
    }
}
