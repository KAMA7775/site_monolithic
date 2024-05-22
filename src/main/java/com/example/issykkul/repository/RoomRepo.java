package com.example.issykkul.repository;

import com.example.issykkul.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepo extends JpaRepository<RoomEntity,Long> {
    List<RoomEntity> findAllByHotelId(Long hotelId);
}
