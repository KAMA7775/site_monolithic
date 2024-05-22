package com.example.issykkul.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
@Entity
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double cost;
    private LocalDate checkinDate;
    private LocalDate checkoutDate;

    public BookingEntity(Long id, double cost, LocalDate checkinDate, LocalDate checkoutDate) {
        this.id = id;
        this.cost = cost;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
    }
    public double getCost() {

        return cost;
    }

    public void setCost(double cost) {

        this.cost = cost;
    }

    public LocalDate getCheckinDate() {

        return checkinDate;
    }

    public void setCheckinDate(LocalDate checkinDate) {

        this.checkinDate = checkinDate;
    }

    public LocalDate getCheckoutDate() {

        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {

        this.checkoutDate = checkoutDate;
    }
}
