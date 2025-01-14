package com.example.testassigment.service;

import com.example.testassigment.dto.MeasurementDTO;
import com.example.testassigment.model.Measurement;
import com.example.testassigment.model.Sensor;
import com.example.testassigment.repository.MeasurementRepository;
import com.example.testassigment.repository.SensorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasurementService {
    private final MeasurementRepository measurementRepository;
    private final SensorRepository sensorRepository;

    public MeasurementService(MeasurementRepository measurementRepository, SensorRepository sensorRepository) {
        this.measurementRepository = measurementRepository;
        this.sensorRepository = sensorRepository;
    }

    public Measurement addMeasurement(MeasurementDTO measurementDTO) {
        Sensor sensor = sensorRepository.findByName(measurementDTO.getSensor().getName())
                .orElseThrow(() -> new RuntimeException("Sensor not found"));

        Measurement measurement = new Measurement();
        measurement.setValue(measurementDTO.getValue());
        measurement.setRaining(measurementDTO.getRaining());
        measurement.setSensor(sensor);
        return measurementRepository.save(measurement);
    }

    public List<Measurement> getAllMeasurements() {
        return measurementRepository.findAll();
    }

    public long countRainyDays() {
        return measurementRepository.countRainyDays();
    }
}