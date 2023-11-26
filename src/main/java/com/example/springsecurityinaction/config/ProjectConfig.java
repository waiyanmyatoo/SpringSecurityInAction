package com.example.springsecurityinaction.config;

import com.example.springsecurityinaction.services.InMemoryUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;

    /// Our own custom user details service

    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails u = new User("john", "12345", List.of(() -> "read"));

        List<UserDetails> users = List.of(u);

        return new InMemoryUserDetailsService(users);
    }

    //    @Bean
//    public UserDetailsService userDetailsService() {
//        var userDetailsManager = new InMemoryUserDetailsManager();
//
//        var user = User.withUsername("john").password("12345").authorities("read").build();
//
//        userDetailsManager.createUser(user);
//
//        return userDetailsManager;
//    }
//
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    /// alternative way to configure userdetails service and password encoder
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        var userDetailsService = new InMemoryUserDetailsManager(); // Declares a UserDetailsSevice to store the users in memory
//
//        var user = User.withUsername("john").password("12345").authorities("read").build();
//
//        userDetailsService.createUser(user);
//
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());

//        auth.authenticationProvider(customAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();

        http.authorizeRequests().anyRequest().authenticated();
    }
}
