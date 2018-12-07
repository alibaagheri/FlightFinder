package com.northland.CheapFlightFinder.amadeus;

import com.northland.CheapFlightFinder.CheapFlightFinderApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CheapFlightFinderApplication.class)
public class AmadeusSerivceProviderTest {

    private static final String BASE_URL = "https://api.sandbox.amadeus.com/v1.2/flights/extensive-search?apikey=em1flj0zpInQKYpHLeBx6dVZlrgoct1H&origin=FRA";
    @Autowired
    RestTemplate restTemplate;

    @MockBean
    private AmadeusSerivceProvider amadeusSerivceProvider;
    LocalDate tenDaysLater = LocalDate.now().plusDays(10);
    private String properTestFlightExtensiveSearchUrl = BASE_URL + "&destination=LON&departure_date=" + tenDaysLater.toString();
    private String improperTestFlightExtensiveSearchUrl = BASE_URL + "&destination=FRA&departure_date=" + tenDaysLater.toString();

    @Test
    public void returnWithOKStatus() {
        String response = restTemplate.getForObject(properTestFlightExtensiveSearchUrl, String.class);
        Assert.assertTrue(response.contains("origin"));
        Assert.assertTrue(response.contains("currency"));
        Assert.assertTrue(response.contains("results"));
    }

    @Test(expected = HttpClientErrorException.class)
    public void returnWithBadRequestStatus() {
        String response = restTemplate.getForObject(improperTestFlightExtensiveSearchUrl, String.class);
        System.out.println(response);
    }
}
