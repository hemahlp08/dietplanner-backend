package com.nutrition.dietplanner.controller;

import com.nutrition.dietplanner.entity.User;
import com.nutrition.dietplanner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Object  register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public Object login(@RequestBody User user) {
        return userService.login(user);
    }
}