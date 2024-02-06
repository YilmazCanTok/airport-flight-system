package com.example.airportflightsystem.controller;

import com.example.airportflightsystem.entity.Airway;
import com.example.airportflightsystem.service.AirwayService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AirwayController.class)
public class AirwayControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AirwayService airwayService;

    private Airway validAirway;

    @BeforeEach
    public void setUp() {
        validAirway = Airway.builder()
                .id(1)
                .city("City A")
                .build();
    }

    @Test
    public void testGetAllAirways() throws Exception {
        List<Airway> airways = Arrays.asList(validAirway);
        Mockito.when(airwayService.getAllAirways()).thenReturn(airways);

        mockMvc.perform(get("/api/airway/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].city", is(validAirway.getCity())));
    }

    @Test
    public void testGetAirway() throws Exception {
        Mockito.when(airwayService.getAirway(validAirway.getId())).thenReturn(validAirway);

        mockMvc.perform(get("/api/airway/{id}", validAirway.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(validAirway.getId())))
                .andExpect(jsonPath("$.city", is(validAirway.getCity())));
    }

    @Test
    public void testAddAirway() throws Exception {
        Mockito.doNothing().when(airwayService).addAirway(Mockito.any(Airway.class));

        mockMvc.perform(post("/api/airway/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(validAirway)))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateAirway() throws Exception {
        Mockito.when(airwayService.updateAirway(Mockito.any(Airway.class))).thenReturn(validAirway);

        mockMvc.perform(put("/api/airway/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(validAirway)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(validAirway.getId())))
                .andExpect(jsonPath("$.city", is(validAirway.getCity())));
    }

    @Test
    public void testDeleteAirway() throws Exception {
        Mockito.when(airwayService.deleteAirway(validAirway.getId())).thenReturn(true);

        mockMvc.perform(delete("/api/airway/delete")
                        .param("id", String.valueOf(validAirway.getId())))
                .andExpect(status().isOk());
    }
}
