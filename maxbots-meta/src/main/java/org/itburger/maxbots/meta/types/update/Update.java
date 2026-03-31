package org.itburger.maxbots.meta.types.update;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "update_type", visible = true, defaultImpl = UnknownUpdate.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = MessageCreatedUpdate.class,   name = "message_created"),
    @JsonSubTypes.Type(value = MessageCallbackUpdate.class,  name = "message_callback"),
    @JsonSubTypes.Type(value = MessageEditedUpdate.class,    name = "message_edited"),
    @JsonSubTypes.Type(value = MessageRemovedUpdate.class,   name = "message_removed"),
    @JsonSubTypes.Type(value = BotAddedUpdate.class,         name = "bot_added"),
    @JsonSubTypes.Type(value = BotRemovedUpdate.class,       name = "bot_removed"),
    @JsonSubTypes.Type(value = UserAddedUpdate.class,        name = "user_added"),
    @JsonSubTypes.Type(value = UserRemovedUpdate.class,      name = "user_removed"),
    @JsonSubTypes.Type(value = BotStartedUpdate.class,       name = "bot_started"),
    @JsonSubTypes.Type(value = BotStoppedUpdate.class,       name = "bot_stopped"),
    @JsonSubTypes.Type(value = ChatTitleChangedUpdate.class, name = "chat_title_changed"),
    @JsonSubTypes.Type(value = DialogMutedUpdate.class,      name = "dialog_muted"),
    @JsonSubTypes.Type(value = DialogUnmutedUpdate.class,    name = "dialog_unmuted"),
    @JsonSubTypes.Type(value = DialogClearedUpdate.class,    name = "dialog_cleared"),
    @JsonSubTypes.Type(value = DialogRemovedUpdate.class,    name = "dialog_removed")
})
public abstract class Update {

    @JsonProperty("update_type")
    private String updateType;

    @JsonProperty("timestamp")
    private Long timestamp;

}
