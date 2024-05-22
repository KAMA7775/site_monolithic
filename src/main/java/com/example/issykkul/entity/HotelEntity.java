package com.example.issykkul.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class HotelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String address;
    private String city;
    private int price;

    public HotelEntity(Long Id, String name,String address,String city, int price) {
        this.Id = Id;
        this.name=name;
        this.address=address;
        this.city=city;
        this.price=price;
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
    public String getCity() {
        return city;
    }

    public void setCity(String city) {

        this.city = city;
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price=price;
    }

    public void setApproved(boolean b) {
    }

    public void setOwner(CustomerEntity owner) {
    }
}
