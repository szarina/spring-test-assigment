package com.example.simpleproject;


import com.example.simpleproject.controller.MeasurementsController;
import com.example.simpleproject.dto.MeasurementsDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class MeasurementsControllerTest {

    @InjectMocks
    private MeasurementsController measurementsController;

    @Mock
    private MeasurementsDTO mockMeasurement;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(measurementsController).build();
    }

    @Test
    void testRegistrationSuccess() throws Exception {
        MeasurementsDTO measurementsDTO = new MeasurementsDTO();
        measurementsDTO.setRaining(true);

        mockMvc.perform(post("/measurements/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"raining\":true}")
                )
                .andExpect(status().isOk())
                .andExpect(content().string("Success"));


        assertTrue(measurementsController.measurementsDTOs.size() > 0);
    }

    @Test
    void testGetMeasurements() throws Exception {
        MeasurementsDTO measurementsDTO = new MeasurementsDTO();
        measurementsDTO.setRaining(true);
        measurementsController.measurementsDTOs.add(measurementsDTO);

        mockMvc.perform(get("/measurements"))
                .andExpect(status().isOk())
                .andExpect(result -> assertTrue(result.getResponse().getContentAsString().contains("raining")));
    }

    @Test
    void testGetRainyDaysCount() throws Exception {
        MeasurementsDTO measurementsDTO1 = new MeasurementsDTO();
        measurementsDTO1.setRaining(true);
        MeasurementsDTO measurementsDTO2 = new MeasurementsDTO();
        measurementsDTO2.setRaining(false);

        measurementsController.measurementsDTOs.add(measurementsDTO1);
        measurementsController.measurementsDTOs.add(measurementsDTO2);

        mockMvc.perform(get("/measurements/rainyDaysCount"))
                .andExpect(status().isOk())
                .andExpect(result -> assertEquals("1", result.getResponse().getContentAsString()));
    }

    @Test
    void testGetRainyDaysCountNoRain() throws Exception {
        MeasurementsDTO measurementsDTO1 = new MeasurementsDTO();
        measurementsDTO1.setRaining(false);
        MeasurementsDTO measurementsDTO2 = new MeasurementsDTO();
        measurementsDTO2.setRaining(false);

        measurementsController.measurementsDTOs.add(measurementsDTO1);
        measurementsController.measurementsDTOs.add(measurementsDTO2);

        mockMvc.perform(get("/measurements/rainyDaysCount"))
                .andExpect(status().isOk())
                .andExpect(result -> assertEquals("0", result.getResponse().getContentAsString()));
    }
}
