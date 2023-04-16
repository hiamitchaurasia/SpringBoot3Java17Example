package org.example.controller;

import org.example.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/users")
    public User getUsers(){
        return new User("Amit", "Chaurasia","hiamitchaurasia","801");
    }
}
