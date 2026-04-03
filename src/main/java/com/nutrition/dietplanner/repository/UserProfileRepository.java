package com.nutrition.dietplanner.repository;

import com.nutrition.dietplanner.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}