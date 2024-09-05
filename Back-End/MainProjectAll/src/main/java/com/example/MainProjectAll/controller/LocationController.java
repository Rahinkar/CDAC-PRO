package com.example.MainProjectAll.controller;


import com.example.MainProjectAll.entity.Location;
import com.example.MainProjectAll.services.LocationService;
import com.example.MainProjectAll.services.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Controller

@RequestMapping("/api/locations")
@CrossOrigin(origins = "http://localhost:3000")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @Autowired
    private SmsService smsService;

    @GetMapping
    public List<Location> getAllLocations() {
        return locationService.getAllLocations();
    }

    @GetMapping("/{id}")
    public Location getLocationById(@PathVariable Long id) {
        return locationService.getLocationById(id);
    }

    @PostMapping
    public Location saveLocation(@RequestBody Location location) {
        Location savedLocation = locationService.saveLocation(location);
        String message = "New location added: Lat: " + savedLocation.getLatitude() + ", Lon: " + savedLocation.getLongitude();
        smsService.sendSms(savedLocation.getPhoneNumber(), message);
        return savedLocation;
    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
    }
}

