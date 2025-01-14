package com.example.testassigment.dto;

import javax.validation.constraints.NotBlank;

public class SensorDTO {
    @NotBlank
    private String name;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}