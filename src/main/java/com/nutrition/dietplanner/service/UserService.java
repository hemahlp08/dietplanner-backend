package com.nutrition.dietplanner.service;

import com.nutrition.dietplanner.entity.User;
import com.nutrition.dietplanner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String register(User user) {
        User existing = userRepository.findByUsername(user.getUsername());
        if (existing != null) {
            return "User already exists";
        }
        userRepository.save(user);
        return "Registered successfully";
    }

    public String login(User user) {
        User existing = userRepository.findByUsername(user.getUsername());

        if (existing == null) {
            return "User not found";
        }

        if (!existing.getPassword().equals(user.getPassword())) {
            return "Wrong password";
        }

        return "Login successful";
    }
}