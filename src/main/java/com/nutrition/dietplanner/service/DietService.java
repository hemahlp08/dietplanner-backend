package com.nutrition.dietplanner.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutrition.dietplanner.entity.DietPlan;
import com.nutrition.dietplanner.repository.DietPlanRepository;

@Service
public class DietService {

    @Autowired
    private DietPlanRepository repo;

    public List<String> generatePlan(Map<String, Object> request) {

        // 🔥 SAFE PARSING (THIS FIXES YOUR ERROR)
        int age = Integer.parseInt(request.get("age").toString());
        double weight = Double.parseDouble(request.get("weight").toString());
        double height = Double.parseDouble(request.get("height").toString());
        String gender = request.get("gender").toString();
        String goal = request.get("goal").toString();
        String dietType = request.get("dietType").toString();
        int meals = Integer.parseInt(request.get("mealsPerDay").toString());
        Long userId = Long.parseLong(request.get("userId").toString());

        List<String> plan = new ArrayList<>();

        // 🍽️ BASE PLAN
        plan.add("Breakfast: Milk + Banana + Nuts");
        plan.add("Lunch: Rice + Dal + Vegetables");
        plan.add("Dinner: Roti + Protein (Paneer/Chicken)");
        plan.add("Snacks: Fruits + Dry fruits");

        // 🔥 SMART LOGIC
        if (goal.equalsIgnoreCase("weight loss")) {
            plan.add("Tip: Avoid sugar and fried foods");
            plan.add("Tip: Maintain calorie deficit");
        }

        if (goal.equalsIgnoreCase("muscle gain")) {
            plan.add("Tip: Increase protein intake");
            plan.add("Tip: Do strength training");
        }

        if (weight > 80) {
            plan.add("Extra Tip: Add cardio daily");
        }

        if (dietType.equalsIgnoreCase("veg")) {
            plan.add("Protein Source: Paneer, Dal, Soybean");
        } else {
            plan.add("Protein Source: Chicken, Eggs, Fish");
        }

        if (age > 40) {
            plan.add("Health Tip: Reduce oil and salt intake");
        }

        // 💾 SAVE TO DATABASE
        DietPlan dp = new DietPlan();
        dp.setAge(age);
        dp.setWeight(weight);
        dp.setHeight(height);
        dp.setGender(gender);
        dp.setGoal(goal);
        dp.setDietType(dietType);
        dp.setMeals(meals);
        dp.setUserId(userId);

        dp.setPlan(String.join(" | ", plan));

        repo.save(dp);

        return plan;
    }
}