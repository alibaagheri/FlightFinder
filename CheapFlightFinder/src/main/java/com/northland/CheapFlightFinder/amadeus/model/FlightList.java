package com.northland.CheapFlightFinder.amadeus.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 *
 * FlightList is used to get flight data from Amadeus web-service result.
 *
 * @author  Ali Bagheri
 *
 */
public class FlightList {
    @JsonProperty("origin")
    private String origin;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("results")
    private List<Flight> results;

    public FlightList() {
    }

    public FlightList(String origin, String currency, List<Flight> results) {
        this.origin = origin;
        this.currency = currency;
        this.results = results;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<Flight> getResults() {
        return results;
    }

    public void setResults(List<Flight> results) {
        this.results = results;
    }
}
