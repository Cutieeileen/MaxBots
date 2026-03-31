package org.itburger.maxbots.meta.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TextFormat {
    MARKDOWN("markdown"),
    HTML("html");

    private final String value;

    TextFormat(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
