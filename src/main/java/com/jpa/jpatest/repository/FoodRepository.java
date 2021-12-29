package com.jpa.jpatest.repository;

import com.jpa.jpatest.entity.Food;
import com.jpa.jpatest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
