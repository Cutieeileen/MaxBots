package org.itburger.maxbots.meta.types.keyboard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestGeoLocationButton extends Button {

    @JsonProperty("quick")
    private Boolean quick;

    public static RequestGeoLocationButton of(String text) {
        return RequestGeoLocationButton.builder()
            .type("request_geo_location")
            .text(text)
            .build();
    }
}
