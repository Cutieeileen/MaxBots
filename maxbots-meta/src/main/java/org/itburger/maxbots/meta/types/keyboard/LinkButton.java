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
public class LinkButton extends Button {

    @JsonProperty("url")
    private String url;

    public static LinkButton of(String text, String url) {
        return LinkButton.builder()
            .type("link")
            .text(text)
            .url(url)
            .build();
    }
}
