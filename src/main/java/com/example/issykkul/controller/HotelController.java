package com.example.issykkul.controller;

import com.example.issykkul.entity.CustomerEntity;
import com.example.issykkul.entity.HotelEntity;
import com.example.issykkul.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping
    public List<HotelEntity> getAllApprovedHotels() {
        return hotelService.findAllApproved();
    }

    @PostMapping
    public ResponseEntity<HotelEntity> requestHotelApproval(@RequestBody HotelEntity hotelEntity, @AuthenticationPrincipal CustomerEntity owner) {
        hotelEntity.setOwner(owner);
        hotelEntity.setApproved(false);
        HotelEntity savedHotel = hotelService.save(hotelEntity);
        return new ResponseEntity<>(savedHotel, HttpStatus.CREATED);
    }

    @GetMapping("/pending")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<HotelEntity> getPendingApprovalHotels() {
        return hotelService.findAllPendingApproval();
    }

    @PostMapping("/{hotelId}/approve")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Void> approveHotel(@PathVariable Long hotelId) {
        hotelService.approveHotel(hotelId);
        return ResponseEntity.ok().build();
    }
}
    //Пользователь отправляет запрос на добавление нового отеля, approved = false отель ожидает одобрения модератором
    //Модератор может просмотреть все отели, которые находятся в статусе ожидания потверждения
    //Модератор может одобрить отель approved в true.



