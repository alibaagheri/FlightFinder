package com.northland.CheapFlightFinder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * This class is used as data transfer object to store flight information.
 * This information is used by other classes such as FlightService.
 *
 * @author  Ali Bagheri
 *
 */

@ApiModel(description = "Flight data transfer object")
public class FlightDto {
    @ApiModelProperty(required = true, value = "destination")
    private String destination;
    @ApiModelProperty(required = true, value = "departureDate")
    private String departureDate;
    @ApiModelProperty(required = true, value = "returnDate")
    private String returnDate;
    @ApiModelProperty(required = true, value = "price")
    private double price;
    @ApiModelProperty(required = true, value = "airline")
    private String airline;
    @ApiModelProperty(required = true, value = "popularity")
    private int popularity;

    public FlightDto() {
    }

    /**
     *
     * @param destination of the flight
     * @param departureDate of the flight
     * @param returnDate of the flight
     * @param price of the flight
     * @param airline of the flight
     * @param popularity of the flight
     */
    public FlightDto(String destination, String departureDate, String returnDate, double price, String airline, int popularity) {
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
