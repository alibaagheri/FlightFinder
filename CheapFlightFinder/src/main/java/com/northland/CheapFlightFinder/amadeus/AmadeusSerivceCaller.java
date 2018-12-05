package com.northland.CheapFlightFinder.amadeus;

import com.northland.CheapFlightFinder.amadeus.model.FlightList;
import org.springframework.web.client.RestTemplate;

public class AmadeusSerivceCaller {

    public AmadeusSerivceCaller(RestTemplate restTemplate) {
        FlightList flightList = restTemplate.getForObject("https://sandbox.amadeus.com/travel-innovation-sandbox/apis/get/flights/extensive-search", FlightList.class);
    }

}
