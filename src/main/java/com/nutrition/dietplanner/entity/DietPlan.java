package com.nutrition.dietplanner.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "diet_plan")
public class DietPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔥 NEW FIELD (user linking)
    private Long userId;

    private String gender;
    private int age;
    private double weight;
    private double height;
    private String goal;
    private String dietType;
    private int meals;

    @Column(length = 2000)
    private String plan;

    // ===== GETTERS & SETTERS =====

    public Long getId() { return id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }

    public String getGoal() { return goal; }
    public void setGoal(String goal) { this.goal = goal; }

    public String getDietType() { return dietType; }
    public void setDietType(String dietType) { this.dietType = dietType; }

    public int getMeals() { return meals; }
    public void setMeals(int meals) { this.meals = meals; }

    public String getPlan() { return plan; }
    public void setPlan(String plan) { this.plan = plan; }
}