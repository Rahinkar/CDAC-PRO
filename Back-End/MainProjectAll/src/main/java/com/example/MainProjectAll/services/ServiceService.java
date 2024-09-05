package com.example.MainProjectAll.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MainProjectAll.entity.TravelerService;
import com.example.MainProjectAll.repository.TravelserviceRepo;

@Service
public class ServiceService {

    @Autowired
    private TravelserviceRepo serviceRepository;

    // Create a new service
    public TravelerService createService(TravelerService service) {
        return serviceRepository.save(service);
    }

    // Get all services
    public List<TravelerService> getAllServices() {
        return serviceRepository.findAll();
    }

    // Get a service by ID
    public TravelerService getServiceById(Integer id) {
        return serviceRepository.findById(id).orElse(null);
    }

    // Update a service
    public TravelerService updateService(TravelerService service) {
        return serviceRepository.save(service);
    }

    // Delete a service
    public boolean deleteService(Integer id) {
        serviceRepository.deleteById(id);
        return true;
    }
}
