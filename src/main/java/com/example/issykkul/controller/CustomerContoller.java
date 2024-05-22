package com.example.issykkul.controller;

import com.example.issykkul.entity.CustomerEntity;
import com.example.issykkul.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@Controller
public class CustomerContoller {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<CustomerEntity> registerUser(@RequestBody CustomerEntity customerEntity) {
        CustomerEntity registeredUser = customerService.registerCustomer(customerEntity);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Void> loginUser() {
        return ResponseEntity.ok().build();
    }
}

