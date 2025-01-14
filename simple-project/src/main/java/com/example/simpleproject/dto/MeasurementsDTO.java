package com.example.simpleproject.dto;




public class MeasurementsDTO {


    float value;
    boolean raining;


    SensorDTO sensor;

    public void setSensor(SensorDTO sensor) {
        this.sensor = sensor;
    }

    @Override
    public String toString() {
         return  "Value: " + value + "raining: " + raining + sensor.toString();
    }

    public boolean isRaining() {
        return raining;
    }

    public void setRaining(boolean b) {
        this.raining = b;
    }
}
