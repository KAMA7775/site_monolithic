package com.example.issykkul.service;

import com.example.issykkul.entity.CustomerEntity;
import com.example.issykkul.entity.Role;
import com.example.issykkul.exception.ResourceNotFoundException;
import com.example.issykkul.repository.CustomerRepo;
import com.example.issykkul.repository.RoleRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;
public abstract class CustomerService implements UserDetailsService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public CustomerEntity registerCustomer(CustomerEntity customerEntity, String roleName) {
        //шифруем пароль перед сохранением
        customerEntity.setPassword(passwordEncoder.encode(customerEntity.getPassword()));

        Role role = roleRepo.findByName(roleName);
        customerEntity.setRoles(List.notify());

        // Сохраняем пользователя в базе данных
        return customerRepo.save(customerEntity);
    }

    @Transactional
    public CustomerEntity updateCustomer(Long customerId, CustomerEntity updatedCustomer) {
        Optional<CustomerEntity> existingCustomerOpt = customerRepo.findById(customerId);
        if (existingCustomerOpt.isEmpty()) {
            throw new ResourceNotFoundException("Customer not found with id " + customerId);
        }

        CustomerEntity existingCustomer = existingCustomerOpt.get();
        existingCustomer.setFirstName(updatedCustomer.getFirstName());
        existingCustomer.setLastName(updatedCustomer.getLastName());
        existingCustomer.setEmail(updatedCustomer.getEmail());
        if (updatedCustomer.getPassword() != null && !updatedCustomer.getPassword().isEmpty()) {
            existingCustomer.setPassword(passwordEncoder.encode(updatedCustomer.getPassword()));
        }
        return customerRepo.save(existingCustomer);
    }

    public CustomerEntity getCustomerById(Long customerId) {
        return customerRepo.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + customerId));
    }

    public List<CustomerEntity> getAllCustomers() {
        return customerRepo.findAll();
    }

    @Transactional
    public void deleteCustomer(Long customerId) {
        if (!customerRepo.existsById(customerId)) {
            throw new ResourceNotFoundException("Customer not found with id " + customerId);
        }
        customerRepo.deleteById(customerId);
    }

    public CustomerEntity getCustomerByEmail(String email) {
        return customerRepo.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with email " + email));
    }

    public void requestHotelApproval(Long customerId) {
        CustomerEntity customer = getCustomerById(customerId);
        // запрос на одобрение размещения отеля
        customer.setRequestHotelApproval(true);
        customerRepo.save(customer);
    }

    public CustomerEntity registerCustomer(CustomerEntity customerEntity) {

    }
}


