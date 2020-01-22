package com.nowak.demo.security;

import com.nowak.demo.authentication.AuthProvider;
import com.nowak.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.security.auth.callback.TextInputCallback;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final AuthProvider authProvider;

    private final UserService userService;

    public SecurityConfiguration(AuthProvider authProvider, UserService userService) {
        this.authProvider = authProvider;
        this.userService = userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/", "/login", "/home", "/process-login").permitAll()
                .antMatchers("/main").permitAll()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                //     .defaultSuccessUrl("/home")
                .loginProcessingUrl("/process-login")
                .successHandler(authProvider)
                      .usernameParameter("username")
                    .passwordParameter("password")
                .and()
                .rememberMe()  //default 2 w
                .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(28))
                .key("rememebermeSecurekey") //key to hash username and exp date
                .rememberMeParameter("loginRemmber")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID", "remember-me");

    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
