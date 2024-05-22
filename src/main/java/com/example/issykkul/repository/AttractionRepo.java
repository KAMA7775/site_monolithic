package com.example.issykkul.repository;

import com.example.issykkul.entity.AttractionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttractionRepo extends JpaRepository <AttractionEntity,Long> {
}
