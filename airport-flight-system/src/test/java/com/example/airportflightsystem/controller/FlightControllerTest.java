package com.example.airportflightsystem.controller;

import com.example.airportflightsystem.entity.Flight;
import com.example.airportflightsystem.service.FlightService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

@ExtendWith(SpringExtension.class)
@WebMvcTest(FlightController.class)
@WithMockUser(username = "yilmaz", roles = {"ADMIN"})
public class FlightControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FlightService flightService;

    private Flight validFlight;

    @BeforeEach
    public void setUp() {
        validFlight = Flight.builder()
                .id(1)
                .departureAirline("Airline A")
                .arrivalAirline("Airline B")
                .price(100)
                .departureDate(new Date())
                // .gettingBackDate() eğer gidiş-dönüş ise burayı doldurun
                .build();
    }

    @Test
    public void testGetAllFlights() throws Exception {
        Mockito.when(flightService.getAllFlights()).thenReturn(Arrays.asList(validFlight));

        mockMvc.perform(get("/api/flight/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(validFlight.getId())));
    }

    @Test
    public void testGetFlight() throws Exception {
        Mockito.when(flightService.getFlight(1)).thenReturn(validFlight);

        mockMvc.perform(get("/api/flight/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(validFlight.getId())));
    }

    @Test
    public void testAddFlight() throws Exception {
        Mockito.doNothing().when(flightService).addFlight(Mockito.any(Flight.class));

        mockMvc.perform(post("/api/flight/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(validFlight)))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateFlight() throws Exception {
        Mockito.when(flightService.updateFlight(Mockito.any(Flight.class))).thenReturn(validFlight);

        mockMvc.perform(put("/api/flight/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(validFlight)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(validFlight.getId())));
    }

    @Test
    public void testDeleteFlight() throws Exception {
        Mockito.when(flightService.deleteFlight(1)).thenReturn(true);

        mockMvc.perform(delete("/api/flight/delete")
                        .param("id", "1"))
                .andExpect(status().isOk());
    }
}
