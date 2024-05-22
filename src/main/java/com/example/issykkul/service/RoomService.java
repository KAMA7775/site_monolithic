package com.example.issykkul.service;

import com.example.issykkul.entity.RoomEntity;
import com.example.issykkul.exception.ResourceNotFoundException;
import com.example.issykkul.repository.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
   private RoomRepo roomRepo;
    public RoomEntity createRoom(RoomEntity room) {
        return roomRepo.save(room);
    }

    public List<RoomEntity> getAllRoomsByHotelId(Long hotelId) {
        return roomRepo.findAllByHotelId(hotelId);
    }

    public RoomEntity getRoomById(Long id) {
        return roomRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found with id " + id));
    }

    public RoomEntity updateRoom(RoomEntity room) {
        return roomRepo.save(room);
    }

    public void deleteRoom(Long id) {
        roomRepo.deleteById(id);
    }
}