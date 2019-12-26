package com.nowak.demo.service;

import com.nowak.demo.entities.Subscription;
import com.nowak.demo.entities.User;
import com.nowak.demo.respos.SubscriptionRepository;
import com.nowak.demo.respos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private Collection<SimpleGrantedAuthority> mapToSubscriptions(Collection<Subscription> subscriptions) {
        System.out.println("converting roles...");
        return subscriptions.stream().map(a -> new SimpleGrantedAuthority(a.getSubscription())).collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User userToLoad = userRepository.findByEmail(s);
        if(userToLoad==null){
            throw new UsernameNotFoundException("User not found");
        }

        return new org.springframework.security.core.userdetails.User(userToLoad.getEmail(),userToLoad.getPassword(),mapToSubscriptions(userToLoad.getSubscriptionCollection()));
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
