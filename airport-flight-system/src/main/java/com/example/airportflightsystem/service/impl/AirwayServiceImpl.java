package com.example.airportflightsystem.service.impl;

import com.example.airportflightsystem.entity.Airway;
import com.example.airportflightsystem.exception.NotFoundException;
import com.example.airportflightsystem.repository.AirwayRepository;
import com.example.airportflightsystem.service.AirwayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AirwayServiceImpl implements AirwayService {
    private final AirwayRepository airwayRepository;
    @Override
    public Airway getAirway(Integer id) {
        Optional<Airway> byId = airwayRepository.findById(id);
        return byId.orElseThrow(() -> new NotFoundException("Airway"));
    }

    @Override
    public List<Airway> getAllAirways() {
        return airwayRepository.findAll();
    }

    @Override
    public void addAirway(Airway airway) {
        airwayRepository.save(airway);
    }

    @Override
    public Airway updateAirway(Airway airway) {
        return airwayRepository.save(airway);
    }

    @Override
    public boolean deleteAirway(Integer id) {
        airwayRepository.delete(getAirway(id));
        return true;
    }
}
