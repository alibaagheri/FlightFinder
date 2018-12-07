package com.northland.CheapFlightFinder.amadeus;

import com.northland.CheapFlightFinder.amadeus.model.FlightList;
import com.northland.CheapFlightFinder.errorhandling.exception.CustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpMethod.GET;

/**
 *
 * @author  Ali Bagheri
 *
 */
@Component
public class AmadeusSerivceProvider implements MessageSourceAware {

    private static final Logger log = LoggerFactory.getLogger(AmadeusSerivceProvider.class);

    private final String serviceUrl;
    private final String apiKey;

    private final RestTemplate restTemplate;

    MessageSource messageSource;

    public AmadeusSerivceProvider(@Value("${amadeus.flight-service.url}") String serviceUrl,
                                  @Value("${amadeus.consumer.key}") String apiKey,
                                  RestTemplate restTemplate) {
        this.serviceUrl = serviceUrl;
        this.apiKey = apiKey;
        this.restTemplate = restTemplate;
    }

    public FlightList getFlightList(String origin, String destination, String departureDate) {
        log.info("Calling Amadeus service");

        try {
            //Set some headers before sending the request
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Accept", "*/*");
            httpHeaders.set("Accept-Language", "en-US");
            httpHeaders.set("Content-Type", "application/json");
            HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);

            String serviceFullUrl = serviceUrl+ "?origin=" + origin + "&destination=" + destination + "&departure_date=" + departureDate + "&one-way=false&apikey=" + apiKey;

            ResponseEntity<FlightList> responseEntity = restTemplate.exchange(serviceFullUrl , GET, httpEntity, FlightList.class);

            // Successful response with FlightList data
            if(responseEntity.getStatusCode().equals(HttpStatus.OK)) {
                log.info("Calling Amadeus service was successful!");
                return responseEntity.getBody();
            } else {
                log.error("bad request " + HttpStatus.BAD_REQUEST);
                throw new CustomException(messageSource.getMessage("bad.request", null, null));
            }

        } catch (RestClientException ex) {
            log.info("Error in calling Amadeus service!");
            throw new CustomException(ex.getMessage());
        }
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}
