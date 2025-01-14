package com.example.testassigment.dto;

import javax.validation.constraints.NotNull;

public class MeasurementDTO {
    @NotNull
    private Double value;

    @NotNull
    private Boolean raining;

    @NotNull
    private SensorDTO sensor;

    public SensorDTO getSensor() {
        return  sensor;
    }

    public Boolean getRaining() {
        return raining;
    }

    public Double getValue() {
        return value;
    }
}