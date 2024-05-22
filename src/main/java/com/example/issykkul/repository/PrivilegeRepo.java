package com.example.issykkul.repository;

import com.example.issykkul.entity.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepo extends JpaRepository<Privilege,Long> {
    Privilege findByName(String name);
}
