package com.quindiflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quindiflix.model.Plan;


public interface PlanRepository extends JpaRepository<Plan, Integer> {
}
