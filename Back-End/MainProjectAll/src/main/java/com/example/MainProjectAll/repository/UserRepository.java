package com.example.MainProjectAll.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MainProjectAll.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
    User findByPhoneNumber(String phoneNumber);
}
