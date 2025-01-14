package com.example.testassigment.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/client")
public class SensorClient {

    private final RestTemplate restTemplate;

    public SensorClient(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @GetMapping("/simulate")
    public String simulate() {
        // Регистрация сенсора
        registerSensor();

        // Генерация 1000 измерений
        generateMeasurements();

        // Получение всех измерений
        getAllMeasurements();

        return "Simulation completed.";
    }

    private void registerSensor() {
        String url = "http://localhost:8080/sensors/registration";
        Map<String, String> sensor = Map.of("name", "sensorName");

        restTemplate.postForEntity(url, sensor, String.class);
    }

    private void generateMeasurements() {
        String url = "http://localhost:8080/measurements/add";

        for (int i = 0; i < 1000; i++) {
            Map<String, Object> measurement = Map.of(
                    "value", Math.random() * 50,
                    "raining", Math.random() < 0.5,
                    "sensor", Map.of("name", "sensorName")
            );

            restTemplate.postForEntity(url, measurement, String.class);
        }
    }

    private void getAllMeasurements() {
        String url = "http://localhost:8080/measurements";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        System.out.println(response.getBody());
    }
}