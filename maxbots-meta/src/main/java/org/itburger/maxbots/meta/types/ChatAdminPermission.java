package org.itburger.maxbots.meta.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ChatAdminPermission {
    READ_ALL_MESSAGES("read_all_messages"),
    ADD_REMOVE_MEMBERS("add_remove_members"),
    ADD_ADMINS("add_admins"),
    CHANGE_CHAT_INFO("change_chat_info"),
    PIN_MESSAGE("pin_message"),
    WRITE("write");

    private final String value;

    ChatAdminPermission(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
