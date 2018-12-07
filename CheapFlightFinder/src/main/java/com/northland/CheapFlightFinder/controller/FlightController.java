package com.northland.CheapFlightFinder.controller;

import com.northland.CheapFlightFinder.model.FlightDto;
import com.northland.CheapFlightFinder.service.FlightService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/api")
@Api(value = "CheapFlightFinder", description = "The service to display three cheapest flights for given source, destination and departure date.")
public class FlightController {

    public FlightController() {
    }

    @Autowired
    FlightService flightService;

    @GetMapping("/cheapest-flights/{origin}/{destination}/{departureDate}")
    @ApiOperation(value = "Returns top 3 cheapest flights", produces = "application/json")
    public List<FlightDto> getCheapesetFlights(@PathVariable String origin, @PathVariable String destination, @PathVariable String departureDate) {
        List<FlightDto> results = flightService.getCheapesetFlights(origin, destination, departureDate);
            return results;
    }
}
