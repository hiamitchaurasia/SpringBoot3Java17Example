package com.hiamitchaurasia.example1.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
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
                //.httpBasic()
                .formLogin();

        return http.build();
    }

    @Bean
    public UserDetailsService jdbcUserDetailsService(DataSource dataSource) {

//        List<UserDetails> userDetailsList = new ArrayList<>();
//        userDetailsList.add(User.withUsername("viewer").password(passwordEncoder().encode("password"))
//                .roles("VIEWER", "USER").build());
//        userDetailsList.add(User.withUsername("editor").password(passwordEncoder().encode("password"))
//                .roles("EDITOR", "USER").build());
//        userDetailsList.add(User.withUsername("admin").password(passwordEncoder().encode("password"))
//                .roles("EDITOR", "ADMIN").build());
//
//        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
//        userDetailsList.forEach(users::createUser);
        String usersByUsernameQuery = "select username, password, enabled from tbl_users where username = ?";
        String authsByUserQuery = "select username, authority from tbl_authorities where username = ?";

        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);

        userDetailsManager.setUsersByUsernameQuery(usersByUsernameQuery);
        userDetailsManager.setAuthoritiesByUsernameQuery(authsByUserQuery);
        System.out.println("My Password: " + passwordEncoder().encode("password"));
        return userDetailsManager;
    }

//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager()
//    {
//        List<UserDetails> userDetailsList = new ArrayList<>();
//        userDetailsList.add(User.withUsername("viewer").password(passwordEncoder().encode("password"))
//                .roles("VIEWER", "USER").build());
//        userDetailsList.add(User.withUsername("editor").password(passwordEncoder().encode("password"))
//                .roles("EDITOR", "USER").build());
//        userDetailsList.add(User.withUsername("admin").password(passwordEncoder().encode("password"))
//                .roles("EDITOR", "ADMIN").build());
//
//        return new InMemoryUserDetailsManager(userDetailsList);
//    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}