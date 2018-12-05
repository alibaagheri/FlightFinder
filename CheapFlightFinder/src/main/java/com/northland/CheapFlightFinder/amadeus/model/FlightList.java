package com.northland.CheapFlightFinder.amadeus.model;

import java.util.List;

public class FlightList {
    private String origin;
    private String currency;
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
