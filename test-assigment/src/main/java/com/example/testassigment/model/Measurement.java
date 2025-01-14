package com.example.testassigment.model;

import jakarta.persistence.*;


@Entity
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "measurement_value")
    private Double value;

    @Column(nullable = false)
    private Boolean raining;

    @ManyToOne
    @JoinColumn(name = "sensor_id", nullable = false)
    private Sensor sensor;

    // Getters and setters

    public void setValue(Double value) {
        this.value = value;
    }

    public void setRaining(Boolean raining) {
        this.raining = raining;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}