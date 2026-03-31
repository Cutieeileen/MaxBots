package org.itburger.maxbots.meta.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ChatType {
    CHAT("chat"),
    DIALOG("dialog"),
    CHANNEL("channel");

    private final String value;

    ChatType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
