package com.nutrition.dietplanner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nutrition.dietplanner.entity.DietPlan;

public interface DietPlanRepository extends JpaRepository<DietPlan, Long> {

    List<DietPlan> findByUserId(Long userId);
}