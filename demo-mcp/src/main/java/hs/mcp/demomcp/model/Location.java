package hs.mcp.demomcp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/* Model based on the class from WeatherApi.com */
public record Location(
        @JsonProperty("name") String name,
        @JsonProperty("region") String region,
        @JsonProperty("country") String country,
        @JsonProperty("lat") BigDecimal lat,
        @JsonProperty("lon") BigDecimal lon,
        @JsonProperty("tz_id") String tzId,
        @JsonProperty("localtime_epoch") Integer localtimeEpoch,
        @JsonProperty("localtime") String localtime
) {
}
