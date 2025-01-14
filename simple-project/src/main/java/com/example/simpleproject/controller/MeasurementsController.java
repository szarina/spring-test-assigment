package com.example.simpleproject.controller;

import com.example.simpleproject.dto.MeasurementsDTO;
import com.example.simpleproject.dto.SensorDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController

public class MeasurementsController {

    public ArrayList<MeasurementsDTO> measurementsDTOs = new ArrayList<MeasurementsDTO>();

    @PostMapping("/measurements/add")
    public String registration(@RequestBody MeasurementsDTO measurementsDTO){
        measurementsDTOs.add(measurementsDTO);
        return  "Success";
    }

    @GetMapping("/measurements")
    public String getMeasurements(){

        StringBuilder res = new StringBuilder();
        for ( var i :measurementsDTOs) {
            res.append(i.toString());
        }
        return res.toString();
    }

    @GetMapping("/measurements/rainyDaysCount")
    public int getRainyDaysCount(){

        int res = 0;
        for ( var i :measurementsDTOs) {
            if ( i.isRaining()){
                res++;
            }

        }
        return res;
    }
}
