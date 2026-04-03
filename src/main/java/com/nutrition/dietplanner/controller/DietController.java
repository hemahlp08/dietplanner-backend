package com.nutrition.dietplanner.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nutrition.dietplanner.entity.DietPlan;
import com.nutrition.dietplanner.repository.DietPlanRepository;
import com.nutrition.dietplanner.service.DietService;

@RestController
@RequestMapping("/api/diet")
@CrossOrigin(origins = "*")
public class DietController {

    @Autowired
    private DietService service;

    @Autowired
    private DietPlanRepository dietPlanRepository;

    @PostMapping("/generate")
    public List<String> generate(@RequestBody Map<String, Object> request) {

        // 1. Generate plan
        List<String> planList = service.generatePlan(request);
        String fullPlan = String.join(", ", planList);

        // 2. Create entity
        DietPlan dp = new DietPlan();

        dp.setGender((String) request.get("gender"));
        dp.setGoal((String) request.get("goal"));
        dp.setDietType((String) request.get("dietType"));

        dp.setAge(Integer.parseInt(request.get("age").toString()));
        dp.setMeals(Integer.parseInt(request.get("mealsPerDay").toString()));

        dp.setWeight(Double.parseDouble(request.get("weight").toString()));
        dp.setHeight(Double.parseDouble(request.get("height").toString()));

        dp.setPlan(fullPlan);

        // 🔥 NEW: set userId
        dp.setUserId(Long.parseLong(request.get("userId").toString()));

        // 3. Save
        dietPlanRepository.save(dp);

        return planList;
    }

    // 🔥 OPTIONAL: get user history
    @GetMapping("/user/{id}")
    public List<DietPlan> getUserPlans(@PathVariable Long id) {
        return dietPlanRepository.findByUserId(id);
    }
}