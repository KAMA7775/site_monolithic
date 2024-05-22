package com.example.issykkul.repository;

import com.example.issykkul.entity.CustomerEntity;
import com.example.issykkul.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<ReviewEntity,Long> {
}
