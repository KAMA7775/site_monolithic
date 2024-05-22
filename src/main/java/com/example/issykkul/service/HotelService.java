package com.example.issykkul.service;

import com.example.issykkul.entity.HotelEntity;
import com.example.issykkul.repository.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
   @Autowired
private HotelRepo hotelRepo;
    public List<HotelEntity> findAllApproved() {
        return hotelRepo.findByApproved(true);
    }

    public List<HotelEntity> findAllPendingApproval() {
        return hotelRepo.findByApproved(false);
    }

    public HotelEntity save(HotelEntity hotelEntity) {
        return hotelRepo.save(hotelEntity);
    }

    public void approveHotel(Long hotelId) {
        HotelEntity hotelEntity = hotelRepo.findById(hotelId).orElseThrow(() -> new IllegalArgumentException("Invalid hotel Id:" + hotelId));
        hotelEntity.setApproved(true);
        hotelRepo.save(hotelEntity);
    }
}