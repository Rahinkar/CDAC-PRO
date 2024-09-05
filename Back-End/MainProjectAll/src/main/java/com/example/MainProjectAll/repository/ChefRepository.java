package com.example.MainProjectAll.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MainProjectAll.entity.Chef;

@Repository
public interface ChefRepository extends JpaRepository<Chef, Long> {
	List<Chef> findByCuisine(String cuisine);
}

