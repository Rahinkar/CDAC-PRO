package com.example.MainProjectAll.services;


import com.example.MainProjectAll.entity.Chef;
import com.example.MainProjectAll.repository.ChefRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChefService {
    @Autowired
    private ChefRepository chefRepository;

    public List<Chef> findAll() {
        return chefRepository.findAll();
    }

    public Optional<Chef> findById(Long id) {
        return chefRepository.findById(id);
    }

    public Chef save(Chef chef) {
        return chefRepository.save(chef);
    }

    public void deleteById(Long id) {
        chefRepository.deleteById(id);
    }

    public List<Chef> findByCuisine(String cuisine) {
        return chefRepository.findByCuisine(cuisine);
    }
}
