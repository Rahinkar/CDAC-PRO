package com.example.MainProjectAll.repository;



import com.example.MainProjectAll.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}

