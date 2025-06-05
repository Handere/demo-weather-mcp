package hs.mcp.demomcp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record APIResponse(
        @JsonProperty("location") Location location,
        @JsonProperty("astronomy") Astronomy astronomy
) {
}
