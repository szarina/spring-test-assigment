package com.example.simpleproject.dto;



public class SensorDTO {


    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  " sensor:  " + name +"\n";
    }
}
