package com.example.MainProjectAll.repository;


import com.example.MainProjectAll.entity.DisasterAlert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisasterAlertRepository extends JpaRepository<DisasterAlert, Long> {
}
