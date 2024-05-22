package com.example.issykkul.repository;

import com.example.issykkul.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepo extends JpaRepository<RestaurantEntity,Long> {
}
