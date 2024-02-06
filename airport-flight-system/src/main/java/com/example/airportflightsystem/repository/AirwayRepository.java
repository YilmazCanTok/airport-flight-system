package com.example.airportflightsystem.repository;

import com.example.airportflightsystem.entity.Airway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirwayRepository  extends JpaRepository<Airway, Integer> {
}
