package com.example.airportflightsystem.service;

import com.example.airportflightsystem.entity.Airway;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AirwayService {

    Airway getAirway(Integer id);
    List<Airway> getAllAirways();
    void addAirway(@RequestBody Airway airway);
    Airway updateAirway(@RequestBody Airway airway);
    boolean deleteAirway(Integer id);


}
