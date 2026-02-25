package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestParam String user,
                           @RequestParam String password) {

        return userService.register(user, password);
    }

    @PostMapping("/login")
    public String login(@RequestParam String user,
                        @RequestParam String password) {

        return userService.login(user, password);
    }
}