package com.nowak.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.security.auth.callback.TextInputCallback;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                    .disable()
                .authorizeRequests()
                    .antMatchers("/","/login").permitAll()
                    .antMatchers("/home").hasAnyRole("USER")
                    .anyRequest()
                .authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login").permitAll()
                    .defaultSuccessUrl("/")
                    .usernameParameter("loginEmail")
                    .passwordParameter("loginPassword")
                .and()
                    .rememberMe()  //default 2 w
                    .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(28))
                    .key("rememebermeSecurekey") //key to hash username and exp date
                    .rememberMeParameter("loginRemmber")
                .and()
                    .logout()
                        .logoutUrl("/logout")
                        .clearAuthentication(true)
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID","remember-me")
                        .logoutUrl("/login");

    }
}
