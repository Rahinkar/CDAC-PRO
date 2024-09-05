package com.example.MainProjectAll.controller;


import com.example.MainProjectAll.entity.DisasterAlert;
import com.example.MainProjectAll.repository.DisasterAlertRepository;
import com.example.MainProjectAll.services.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/alerts")
@CrossOrigin(origins = "http://localhost:3000")
public class DisasterAlertController {

    @Autowired
    private DisasterAlertRepository disasterAlertRepository;

    @Autowired
    private SmsService smsService;

    @PostMapping
    public ResponseEntity<DisasterAlert> createAlert(@Validated @RequestBody DisasterAlert alert) {
        try {
            // Save the disaster alert in the database
            DisasterAlert savedAlert = disasterAlertRepository.save(alert);

            // Send SMS notification
            String message = "Disaster Alert: " + alert.getType() + " at " + alert.getLocation() + ". " + alert.getDescription();
            smsService.sendSms(alert.getMobileNumber(), message);

            return ResponseEntity.ok(savedAlert);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
