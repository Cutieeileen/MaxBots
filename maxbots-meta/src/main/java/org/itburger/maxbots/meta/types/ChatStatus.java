package org.itburger.maxbots.meta.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ChatStatus {
    ACTIVE("active"),
    REMOVED("removed"),
    LEFT("left"),
    CLOSED("closed");

    private final String value;

    ChatStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
