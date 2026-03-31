package org.itburger.maxbots.meta.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum UploadType {
    PHOTO("image"),
    VIDEO("video"),
    AUDIO("audio"),
    FILE("file");

    private final String value;

    UploadType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
