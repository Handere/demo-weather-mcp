package hs.mcp.demomcp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/* Model based on the class from WeatherApi.com */
public class Astronomy {
    @JsonProperty("astro")
    private AstronomyAstro astro;

    public Astronomy() {
    }

    public AstronomyAstro getAstro() {
        return astro;
    }

    public void setAstro(AstronomyAstro astro) {
        this.astro = astro;
    }
}
