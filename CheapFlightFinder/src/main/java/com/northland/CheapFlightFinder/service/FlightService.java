package com.northland.CheapFlightFinder.service;

import com.northland.CheapFlightFinder.amadeus.AmadeusSerivceProvider;
import com.northland.CheapFlightFinder.amadeus.model.Flight;
import com.northland.CheapFlightFinder.amadeus.model.FlightList;
import com.northland.CheapFlightFinder.model.FlightDto;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Acts as service layer and is used by other classes like FlightController.
 *
 * @author  Ali Bagheri
 *
 */
@Service
public class FlightService {

    public static final int DESIRED_NUMBER_OF_RESULTS = 3;
    AmadeusSerivceProvider amadeusSerivceProvider;

    /**
     * AmadeusServiceProvider instance has been injected to be used in getCheapesetFlights method.
     *
     * @param amadeusSerivceProvider
     */
    public FlightService(AmadeusSerivceProvider amadeusSerivceProvider) {
        this.amadeusSerivceProvider = amadeusSerivceProvider;
    }

    /**
     * Calls amadeus service and get the results and then maps the results in FlightDto object.
     * Finally it returns the three cheapest flights.
     *
     * @param origin of the flight
     * @param destination of the flight
     * @param departureDate of the flight
     * @return list of FlightDto objects
     */
    public List<FlightDto> getCheapesetFlights(String origin, String destination, String departureDate) {

        if (amadeusSerivceProvider == null)
            return null;

        FlightList flightList = amadeusSerivceProvider.getFlightList(origin, destination, departureDate);

        if (flightList == null)
            return null;

        List<Flight> flights =  flightList.getResults();

        List<FlightDto> flightDtoList = new ArrayList<>();

        flights.stream().forEach(flight -> {
            FlightDto flightDto = new FlightDto(flight.getDestination(), flight.getDepartureDate(),
                                                flight.getReturnDate(), flight.getPrice(), flight.getAirline(),
                                                flight.getPopularity()
                                        );

            flightDtoList.add(flightDto);
        });

        flightDtoList.sort(Comparator.comparing(FlightDto::getPrice));

        return flightDtoList.subList(0, Math.min(DESIRED_NUMBER_OF_RESULTS, flightDtoList.size()));
    }
}
