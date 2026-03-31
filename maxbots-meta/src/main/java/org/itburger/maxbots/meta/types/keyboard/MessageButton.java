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
public class MessageButton extends Button {

    @JsonProperty("payload")
    private String payload;

    public static MessageButton of(String text, String payload) {
        return MessageButton.builder()
            .type("message")
            .text(text)
            .payload(payload)
            .build();
    }
}
