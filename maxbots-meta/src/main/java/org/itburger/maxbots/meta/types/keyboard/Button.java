package org.itburger.maxbots.meta.types.keyboard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = CallbackButton.class, name = "callback"),
    @JsonSubTypes.Type(value = LinkButton.class, name = "link"),
    @JsonSubTypes.Type(value = RequestContactButton.class, name = "request_contact"),
    @JsonSubTypes.Type(value = RequestGeoLocationButton.class, name = "request_geo_location"),
    @JsonSubTypes.Type(value = OpenAppButton.class, name = "open_app"),
    @JsonSubTypes.Type(value = MessageButton.class, name = "message")
})
public abstract class Button {

    @JsonProperty("type")
    private String type;

    @JsonProperty("text")
    private String text;
}
