package com.example.issykkul.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name ="Restaurant")
public class RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String address;
    private String cuisineType;
    private LocalDate openingHours;
    private int averageCheck;
    private int rating;

    public RestaurantEntity(Long Id, String name,String address,String cuisineType,LocalDate openingHours, int averageCheck,int rating) {
        this.Id = Id;
        this.name=name;
        this.address=address;
        this.cuisineType=cuisineType;
        this.openingHours=openingHours;
        this.averageCheck=averageCheck;
        this.rating=rating;
    }

    public Long getId() {

        return Id;
    }

    public void setId(Long Id) {

        this.Id = Id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }
    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address= address;
    }
    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {

        this.cuisineType = cuisineType;
    }
    public LocalDate getOpeningHours() {

        return openingHours;
    }

    public void setOpeningHours(LocalDate openingHours) {

        this.openingHours= openingHours;
    }

    public int getAverageCheck() {

        return averageCheck;
    }
    public void setAverageCheck(int averageCheck) {

        this.averageCheck=averageCheck;
    }
    public int getRating() {

        return rating;
    }
    public void setRating(int rating) {

        this.rating=rating;
    }
}

