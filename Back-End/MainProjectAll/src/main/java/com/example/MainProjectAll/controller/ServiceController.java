package com.example.MainProjectAll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MainProjectAll.entity.TravelerService;
import com.example.MainProjectAll.services.ServiceService;

@RestController
@RequestMapping("/api/services")
@CrossOrigin(origins = "http://localhost:3000")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    // Create a new service
    @PostMapping("/serve")
    public ResponseEntity<TravelerService> createService(@RequestBody TravelerService service) {
    	TravelerService newService = serviceService.createService(service);
        return new ResponseEntity<>(newService, HttpStatus.CREATED);
    }

    // Get all services
    @GetMapping
    public ResponseEntity<List<TravelerService>> getAllServices() {
        List<TravelerService> services = serviceService.getAllServices();
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    // Get a service by ID
    @GetMapping("/{id}")
    public ResponseEntity<TravelerService> getServiceById(@PathVariable Integer id) {
    	TravelerService service = serviceService.getServiceById(id);
        if (service == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service, HttpStatus.OK);
    }

    // Update a service
    @PutMapping("/{id}")
    public ResponseEntity<TravelerService> updateService(@PathVariable Integer id, @RequestBody TravelerService service) {
    	TravelerService updatedService = serviceService.updateService(service);
        return new ResponseEntity<>(updatedService, HttpStatus.OK);
    }

    // Delete a service
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Integer id) {
        serviceService.deleteService(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
