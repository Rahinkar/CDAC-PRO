package com.example.MainProjectAll.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MainProjectAll.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}

