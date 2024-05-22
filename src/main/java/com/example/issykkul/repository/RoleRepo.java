package com.example.issykkul.repository;

import com.example.issykkul.entity.ReviewEntity;
import com.example.issykkul.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
