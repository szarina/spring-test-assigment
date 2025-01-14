package com.example.testassigment.controller;

import com.example.testassigment.dto.MeasurementDTO;
import com.example.testassigment.model.Measurement;
import com.example.testassigment.service.MeasurementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/measurements")
public class MeasurementController {
    private final MeasurementService measurementService;

    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addMeasurement(@Valid @RequestBody MeasurementDTO measurementDTO) {
        measurementService.addMeasurement(measurementDTO);
        return ResponseEntity.ok("Measurement added successfully");
    }

    @GetMapping
    public ResponseEntity<List<Measurement>> getAllMeasurements() {
        return ResponseEntity.ok(measurementService.getAllMeasurements());
    }

    @GetMapping("/rainyDaysCount")
    public ResponseEntity<Long> getRainyDaysCount() {
        return ResponseEntity.ok(measurementService.countRainyDays());
    }
}