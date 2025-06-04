package hs.mcp.demomcp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/* Model based on the class from WeatherApi.com */
public class Location {
    @JsonProperty("name")
    private String name;

    @JsonProperty("region")
    private String region;

    @JsonProperty("country")
    private String country;

    @JsonProperty("lat")
    private BigDecimal lat;

    @JsonProperty("lon")
    private BigDecimal lon;

    @JsonProperty("tz_id")
    private String tzId;

    @JsonProperty("localtime_epoch")
    private Integer localtimeEpoch;

    @JsonProperty("localtime")
    private String localtime;

    public Location() {
    }

    public Location name(String name) {
        this.name = name;
        return this;
    }
}
