package hs.mcp.demomcp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Astronomy(
        @JsonProperty("astro") Astro astro
) {
}
