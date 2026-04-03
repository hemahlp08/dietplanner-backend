package com.nutrition.dietplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nutrition.dietplanner.entity.User;
import com.nutrition.dietplanner.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // ✅ REGISTER
    @PostMapping("/register")
    public String register(@RequestBody User user) {

        User existing = userRepository.findByUsername(user.getUsername());

        if (existing != null) {
            return "User already exists";
        }

        userRepository.save(user);
        return "Registered successfully";
    }

    // ✅ LOGIN (IMPORTANT FIX)
    @PostMapping("/login")
    public Object login(@RequestBody User user) {

        User existingUser = userRepository.findByUsername(user.getUsername());

        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return existingUser; // 🔥 MUST RETURN USER OBJECT
        }

        return "Invalid credentials";
    }
}