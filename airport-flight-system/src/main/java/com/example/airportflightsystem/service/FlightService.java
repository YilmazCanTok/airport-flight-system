package com.example.airportflightsystem.service;

import com.example.airportflightsystem.entity.Flight;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

public interface FlightService {
    List<Flight> getAllFlights();

    Flight getFlight(Integer id);

    void addFlight(@RequestBody Flight flight);

    Flight updateFlight(@RequestBody Flight flight);

    boolean deleteFlight(Integer id);


}
