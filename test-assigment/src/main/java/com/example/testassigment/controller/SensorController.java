package com.example.testassigment.controller;

import com.example.testassigment.dto.SensorDTO;
import com.example.testassigment.service.SensorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/sensors")
public class SensorController {
    private final SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @PostMapping("/registration")
    public ResponseEntity<String> registerSensor(@Valid @RequestBody SensorDTO sensorDTO) {
        sensorService.registerSensor(sensorDTO);
        return ResponseEntity.ok("Sensor registered successfully");
    }
}
