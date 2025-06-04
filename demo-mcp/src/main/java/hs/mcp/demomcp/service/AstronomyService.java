package hs.mcp.demomcp.service;

import hs.mcp.demomcp.model.APIResponse;
import hs.mcp.demomcp.model.AstronomyAstro;
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
    public AstronomyAstro getAstronomy(String cityName, String date) {
        return this.restClient.get()
                .uri("/astronomy.json?key={apiKey}&q={cityName}&dt={date}", apiKey, cityName, date)
                .retrieve()
                .body(APIResponse.class)
                .getAstronomy()
                .getAstro();
    }

    @Tool(name = "get_current_astronomy", description = "Get the location and Astronomy Objects by city name for current day")
    public AstronomyAstro getCurrentAstronomy(String cityName) {
        var localDate = getCurrentDate();
        var response = this.restClient.get()
                .uri("/astronomy.json?key={apiKey}&q={cityName}&dt={date}", apiKey, cityName, localDate)
                .retrieve()
                .body(APIResponse.class);
        log.info(response.getAstronomy().getAstro().toString());
        return response.getAstronomy().getAstro();
    }

    private LocalDate getCurrentDate() {
        return LocalDate.now();
    }
}
