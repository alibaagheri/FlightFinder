package com.northland.CheapFlightFinder.amadeus.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * Flight is used as part of FlightList class to get flight data from Amadeus web-service result.
 *
 * @author  Ali Bagheri
 *
 */
public class Flight {
    @JsonProperty("destination")
    private String destination;
    @JsonProperty("departure_date")
    private String departureDate;
    @JsonProperty("return_date")
    private String returnDate;
    @JsonProperty("price")
    private double price;
    @JsonProperty("airline")
    private String airline;
    @JsonProperty("popularity")
    private int popularity;

    public Flight() {
    }

    public Flight(String destination, String departureDate, String returnDate, double price, String airline, int popularity) {
        this.destination = destination;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.price = price;
        this.airline = airline;
        this.popularity = popularity;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }
}
