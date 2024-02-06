package com.example.airportflightsystem.controller;

import com.example.airportflightsystem.entity.Airway;
import com.example.airportflightsystem.service.AirwayService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/airway")
public class AirwayController {

    //
    private final AirwayService airwayService;

    @GetMapping(value = "/all")
    public List<Airway> getAllAirways() {
        return airwayService.getAllAirways();
    }

    @GetMapping(value = "/{id}")
    public Airway getAirway(@PathVariable @Min(1) Integer id) {
        return airwayService.getAirway(id);
    }

    @PostMapping(value = "/create")
    public void addAirway(@Valid @RequestBody Airway airway) {
        airwayService.addAirway(airway);
    }

    @PutMapping(value = "/update")
    public Airway updateAirway(@Valid @RequestBody Airway airway) {
        return airwayService.updateAirway(airway);
    }

    @DeleteMapping(value = "/delete")
    public boolean deleteAirway(@RequestParam @Min(1) Integer id) {
        return airwayService.deleteAirway(id);
    }

}
