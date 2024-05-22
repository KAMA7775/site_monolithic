package com.example.issykkul.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
@Entity
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String roomType;

    public RoomEntity(Long Id, String roomType) {
        this.Id = Id;
        this.roomType = roomType;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {

        this.Id = Id;
    }

    public String getRoomType() {

        return roomType;
    }

    public void setRoomType(String roomType) {

        this.roomType = roomType;
    }


}

