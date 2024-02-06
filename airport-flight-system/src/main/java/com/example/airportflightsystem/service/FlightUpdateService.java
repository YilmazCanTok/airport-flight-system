
package com.example.airportflightsystem.service;

import com.example.airportflightsystem.entity.Flight;
import com.example.airportflightsystem.repository.FlightRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FlightUpdateService {

    private final FlightRepository flightRepository;

    public FlightUpdateService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Scheduled(cron = "35 35 22 * * *")
    public void updateFlightData() {
        List<Flight> flights = fetchMockFlightData();
        flightRepository.saveAll(flights);
        System.out.println("Uçuş bilgileri güncellendi.");
    }

    private List<Flight> fetchMockFlightData() {
        List<Flight> flights = new ArrayList<>();

        // Şehirler listesi
        String[] cities = new String[]{"Istanbul", "Ankara", "İzmir", "New York", "Washington",
                "Paris", "Toronto", "Madrid", "Berlin", "Dubai",
                "London", "Los Angeles", "Manchester", "Liverpool", "Tokyo"};

        // Mock uçuş bilgileri oluşturma
        flights.add(new Flight(1000, cities[0], cities[3], 1000, new Date(), null)); // İstanbul'dan New York'a
        flights.add(new Flight(1001, cities[4], cities[10], 750, new Date(), new Date())); // Washington'dan London'a
        flights.add(new Flight(1002, cities[14], cities[1], 1200, new Date(), null)); // Tokyo'dan Ankara'ya

        return flights;
    }
}

