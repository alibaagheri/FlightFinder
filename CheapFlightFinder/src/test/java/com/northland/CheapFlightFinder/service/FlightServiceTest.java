package com.northland.CheapFlightFinder.service;

import com.northland.CheapFlightFinder.amadeus.AmadeusSerivceProvider;
import com.northland.CheapFlightFinder.amadeus.model.Flight;
import com.northland.CheapFlightFinder.amadeus.model.FlightList;
import com.northland.CheapFlightFinder.model.FlightDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FlightServiceTest {

    @Mock
    AmadeusSerivceProvider amadeusSerivceProvider;

    FlightService flightService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getThreeCheapestFlights() {
        LocalDate tenDaysLater = LocalDate.now().plusDays(10);
        Mockito.when(amadeusSerivceProvider.getFlightList("FRA", "LON", tenDaysLater.toString())).thenReturn(this.getAmadeusFlightList());
        flightService = new FlightService(amadeusSerivceProvider);
        List<FlightDto> flights = flightService.getCheapesetFlights("FRA", "LON", tenDaysLater.toString());
        Assert.assertEquals(3, flights.size());
        Assert.assertEquals(150.50, flights.get(0).getPrice(), 0.001);
        Assert.assertEquals(160.95, flights.get(1).getPrice(), 0.001);
        Assert.assertEquals(179.65, flights.get(2).getPrice(), 0.001);
    }

    @Test
    public void getCheapestFlightsWhenThereAreLessThatThreeFlights() {
        LocalDate tenDaysLater = LocalDate.now().plusDays(10);
        Mockito.when(amadeusSerivceProvider.getFlightList("FRA", "LON", tenDaysLater.toString())).thenReturn(this.getAmadeusOneFlightList());
        flightService = new FlightService(amadeusSerivceProvider);
        List<FlightDto> flights = flightService.getCheapesetFlights("FRA", "LON", tenDaysLater.toString());
        Assert.assertEquals(1, flights.size());
        Assert.assertEquals(180.35, flights.get(0).getPrice(), 0.001);
    }

    @Test
    public void getCheapestFlightsWhenHereIsNoFlights() {
        LocalDate tenDaysLater = LocalDate.now().plusDays(10);
        Mockito.when(amadeusSerivceProvider.getFlightList("FRA", "LON", tenDaysLater.toString())).thenReturn(this.getAmadeusEmptyFlightList());
        flightService = new FlightService(amadeusSerivceProvider);
        List<FlightDto> flights = flightService.getCheapesetFlights("FRA", "LON", tenDaysLater.toString());
        Assert.assertEquals(0, flights.size());
    }

    @Test
    public void getCheapestFlightsWhenDepartureDateIsInThePast() {
        LocalDate tenDaysLater = LocalDate.now().plusDays(10);
        Mockito.when(amadeusSerivceProvider.getFlightList("FRA", "LON", tenDaysLater.toString())).thenReturn(this.getAmadeusEmptyFlightList());
        flightService = new FlightService(amadeusSerivceProvider);
        List<FlightDto> flights = flightService.getCheapesetFlights("FRA", "LON", tenDaysLater.toString());
        Assert.assertEquals(0, flights.size());
    }

    @Test
    public void getThreeCheapestFlightsWhenOriginAndDestinationAreTheSame() {
        LocalDate tenDaysLater = LocalDate.now().plusDays(10);
        flightService = new FlightService(null);
        List<FlightDto> flights = flightService.getCheapesetFlights("FRA", "FRA", "2018-12-12");
        Assert.assertNull(flights);
    }

    private FlightList getAmadeusEmptyFlightList() {
        FlightList flightList = new FlightList();
        flightList.setOrigin("FRA");
        flightList.setCurrency("EUR");

        List<Flight> flights = new ArrayList<>();

        flightList.setResults(flights);

        return  flightList;
    }

    private FlightList getAmadeusOneFlightList() {
        FlightList flightList = new FlightList();
        flightList.setOrigin("FRA");
        flightList.setCurrency("EUR");

        Flight flight1 = new Flight("LON", "2018-12-12", "2018-12-13", 180.35, "BA", 0);
        List<Flight> flights = new ArrayList<>();
        flights.add(flight1);

        flightList.setResults(flights);

        return  flightList;
    }

    private FlightList getAmadeusFlightList() {
        FlightList flightList = new FlightList();
        flightList.setOrigin("FRA");
        flightList.setCurrency("EUR");

        Flight flight1 = new Flight("LON", "2018-12-12", "2018-12-13", 180.35, "BA", 0);
        Flight flight2 = new Flight("LON", "2018-12-12", "2018-12-13", 160.95, "BA", 0);
        Flight flight3 = new Flight("LON", "2018-12-12", "2018-12-13", 150.50, "BA", 0);
        Flight flight4 = new Flight("LON", "2018-12-12", "2018-12-13", 179.65, "BA", 0);

        List<Flight> flights = new ArrayList<>();
        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        flights.add(flight4);
        flightList.setResults(flights);

        return  flightList;
    }
}
