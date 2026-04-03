package com.nutrition.dietplanner.repository;

import com.nutrition.dietplanner.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}