package com.example.testassigment.service;

import com.example.testassigment.dto.SensorDTO;
import com.example.testassigment.model.Sensor;
import com.example.testassigment.repository.SensorRepository;
import org.springframework.stereotype.Service;

@Service
public class SensorService {
    private final SensorRepository sensorRepository;

    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public Sensor registerSensor(SensorDTO sensorDTO) {
        if (sensorRepository.findByName(sensorDTO.getName()).isPresent()) {
            throw new RuntimeException("Sensor with this name already exists");
        }
        Sensor sensor = new Sensor();
        sensor.setName(sensorDTO.getName());
        return sensorRepository.save(sensor);
    }
}