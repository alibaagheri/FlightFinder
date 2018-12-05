package com.northland.CheapFlightFinder.controller;

import com.northland.CheapFlightFinder.model.FlightDto;
import com.northland.CheapFlightFinder.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FlightController {

    public FlightController() {
    }

    @Autowired
    FlightService flightService;

    @GetMapping("/cheapest-flights")
    public ResponseEntity<FlightDto> getCheapesetFlights(@RequestParam String destination, @RequestParam Date departureDate) {
            List<FlightDto> results = flightService.getCheapesetFlights(destination, departureDate);
            return null;
    }
}
