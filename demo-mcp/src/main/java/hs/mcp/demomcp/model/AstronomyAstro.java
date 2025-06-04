package hs.mcp.demomcp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/* Model based on the class from WeatherApi.com */
public class AstronomyAstro {
    @JsonProperty("sunrise")
    private String sunrise;
    @JsonProperty("sunset")
    private String sunset;
    @JsonProperty("moonrise")
    private String moonrise;
    @JsonProperty("moonset")
    private String moonset;
    @JsonProperty("moon_phase")
    private String moonPhase;
    @JsonProperty("moon_illumination")
    private Integer moonIllumination;
    @JsonProperty("is_moon_up")
    private Boolean isMoonUp;
    @JsonProperty("is_sun_up")
    private Boolean isSunUp;

    public AstronomyAstro() {
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getMoonrise() {
        return moonrise;
    }

    public void setMoonrise(String moonrise) {
        this.moonrise = moonrise;
    }

    public String getMoonset() {
        return moonset;
    }

    public void setMoonset(String moonset) {
        this.moonset = moonset;
    }

    public String getMoonPhase() {
        return moonPhase;
    }

    public void setMoonPhase(String moonPhase) {
        this.moonPhase = moonPhase;
    }

    public Integer getMoonIllumination() {
        return moonIllumination;
    }

    public void setMoonIllumination(Integer moonIllumination) {
        this.moonIllumination = moonIllumination;
    }

    public Boolean getIsMoonUp() {
        return isMoonUp;
    }

    public void setIsMoonUp(Boolean isMoonUp) {
        this.isMoonUp = isMoonUp;
    }

    public Boolean getIsSunUp() {
        return isSunUp;
    }

    public void setIsSunUp(Boolean isSunUp) {
        this.isSunUp = isSunUp;
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return "{" + "\"error\": \"Failed to convert to JSON\"" + "}";
        }
    }
}
