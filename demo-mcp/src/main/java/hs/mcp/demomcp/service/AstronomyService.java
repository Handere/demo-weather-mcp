package hs.mcp.demomcp.service;

import hs.mcp.demomcp.model.APIResponse;
import hs.mcp.demomcp.model.Astro;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.time.LocalDate;

@Service
public class AstronomyService {

    private static final Logger log = LoggerFactory.getLogger(AstronomyService.class);
    private RestClient restClient;

    @Value("${weather.api.key}")
    private String apiKey;

    public AstronomyService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.baseUrl("http://api.weatherapi.com/v1").build();
    }

    @Tool(name = "get_astronomy", description = "Get the location and Astronomy Objects by city name and date in format yyyy-MM-dd")
    public Astro getAstronomy(String cityName, String date) {
        try {
            var response = this.restClient.get()
                    .uri("/astronomy.json?key={apiKey}&q={cityName}&dt={date}", apiKey, cityName, date)
                    .retrieve()
                    .body(APIResponse.class)
                    .astronomy()
                    .astro();
            log.info(response.toString());
            return response;
        } catch (Exception e) {
            log.info("Failed to get Astro: " + e.getMessage());
            return null;
        }
    }

    @Tool(name = "get_current_astronomy", description = "Get the location and Astronomy Objects by city name for current day")
    public Astro getCurrentAstronomy(String cityName) {
        var localDate = getCurrentDate();
        try {
            var response = this.restClient.get()
                    .uri("/astronomy.json?key={apiKey}&q={cityName}&dt={date}", apiKey, cityName, localDate)
                    .retrieve()
                    .body(APIResponse.class)
                    .astronomy()
                    .astro();
            log.info(response.toString());
            return response;
        } catch (Exception e) {
            log.info("Failed to get Astro: " + e.getMessage());
            return null;
        }
    }

    private LocalDate getCurrentDate() {
        return LocalDate.now();
    }
}
