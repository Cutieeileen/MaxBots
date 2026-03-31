package org.itburger.maxbots.meta.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SenderAction {
    TYPING_ON("typing_on"),
    SENDING_PHOTO("sending_photo"),
    SENDING_VIDEO("sending_video"),
    SENDING_AUDIO("sending_audio"),
    SENDING_FILE("sending_file"),
    MARK_SEEN("mark_seen");

    private final String value;

    SenderAction(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
