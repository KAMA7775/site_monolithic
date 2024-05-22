package com.example.issykkul.repository;

import com.example.issykkul.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepo extends JpaRepository<HotelEntity,Long> {
    List<HotelEntity> findByApproved(boolean approved);
}

