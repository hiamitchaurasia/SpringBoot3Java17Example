package com.hiamitchaurasia.example1.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableWebSecurity
public class WebSecurity{

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable().authorizeHttpRequests()
                .requestMatchers("/users").hasRole("manager")
                .anyRequest().authenticated()
                .and()
                .formLogin();

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager()
    {
        List<UserDetails> userDetailsList = new ArrayList<>();
        userDetailsList.add(User.withUsername("viewer").password(passwordEncoder().encode("password"))
                .roles("VIEWER", "USER").build());
        userDetailsList.add(User.withUsername("editor").password(passwordEncoder().encode("password"))
                .roles("EDITOR", "USER").build());
        userDetailsList.add(User.withUsername("admin").password(passwordEncoder().encode("password"))
                .roles("EDITOR", "ADMIN").build());

        return new InMemoryUserDetailsManager(userDetailsList);
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}