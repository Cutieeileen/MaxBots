package org.itburger.maxbots.meta.types.keyboard;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ButtonIntent {
    POSITIVE("positive"),
    NEGATIVE("negative"),
    DEFAULT("default");

    private final String value;

    ButtonIntent(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
