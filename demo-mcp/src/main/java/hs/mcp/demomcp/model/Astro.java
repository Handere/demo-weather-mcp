package hs.mcp.demomcp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/* Model based on the class from WeatherApi.com */
public record Astro(
        @JsonProperty("sunrise") String sunrise,
        @JsonProperty("sunset") String sunset,
        @JsonProperty("moonrise") String moonrise,
        @JsonProperty("moonset") String moonset,
        @JsonProperty("moon_phase") String moonPhase,
        @JsonProperty("moon_illumination") Integer moonIllumination,
        @JsonProperty("is_moon_up") Boolean isMoonUp,
        @JsonProperty("is_sun_up") Boolean isSunUp
) {
}
