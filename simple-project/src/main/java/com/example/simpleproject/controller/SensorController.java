package com.example.simpleproject.controller;


import com.example.simpleproject.dto.SensorDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class SensorController {

    ArrayList<SensorDTO> sensors = new ArrayList<SensorDTO>();

    @PostMapping("/sensors/registration")
    public String registration(@RequestBody SensorDTO sensorDTO){
        for (var i : sensors){
            if (i.getName().equals(sensorDTO.getName())){
                return  "Already exists";
            }
        }
        sensors.add(sensorDTO);
        return  "Success";
    }


}
