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
public class CallbackButton extends Button {

    @JsonProperty("payload")
    private String payload;

    @JsonProperty("intent")
    private ButtonIntent intent;

    public static CallbackButton of(String text, String payload) {
        return CallbackButton.builder()
            .type("callback")
            .text(text)
            .payload(payload)
            .build();
    }
}
