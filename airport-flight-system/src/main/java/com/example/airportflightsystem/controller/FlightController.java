package com.example.airportflightsystem.controller;

import com.example.airportflightsystem.entity.Flight;
import com.example.airportflightsystem.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.Date;
import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/flight")
public class FlightController {
    private final FlightService flightService;
//
    @GetMapping(value="/welcome")
    public String welcome() {
        return "Welcome to Flight Service!";
    }

    @GetMapping(value = "/all")
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping(value = "/{id}")
    public Flight getFlight(@PathVariable @Min(1) Integer id) {
        return flightService.getFlight(id);
    }

    @PostMapping(value = "/create")
    public void addFlight(@Valid @RequestBody Flight flight) {
        flightService.addFlight(flight);
    }

    @PutMapping(value = "/update")
    public Flight updateFlight(@Valid @RequestBody Flight flight) {
        return flightService.updateFlight(flight);
    }

    @DeleteMapping(value = "/delete")
    public boolean deleteFlight(@RequestParam @Min(1) Integer id) {
        return flightService.deleteFlight(id);
    }


}
