package hs.mcp.demomcp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class APIResponse {
    @JsonProperty("location")
    private Location location;
    @JsonProperty("astronomy")
    private Astronomy astronomy;

    public APIResponse() {
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Astronomy getAstronomy() {
        return astronomy;
    }

    public void setAstronomy(Astronomy astronomy) {
        this.astronomy = astronomy;
    }
}
