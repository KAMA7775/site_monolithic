package com.example.issykkul.repository;

import com.example.issykkul.entity.TourEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepo extends JpaRepository<TourEntity,Long> {
}
