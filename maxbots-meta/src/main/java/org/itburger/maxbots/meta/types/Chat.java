package org.itburger.maxbots.meta.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Chat {

    @JsonProperty("chat_id")
    private Long chatId;

    @JsonProperty("type")
    private ChatType type;

    @JsonProperty("status")
    private ChatStatus status;

    @JsonProperty("title")
    private String title;

    @JsonProperty("icon")
    private Image icon;

    @JsonProperty("last_event_time")
    private Long lastEventTime;

    @JsonProperty("participants_count")
    private Integer participantsCount;

    @JsonProperty("owner_id")
    private Long ownerId;

    @JsonProperty("participants")
    private Map<String, Long> participants;

    @JsonProperty("is_public")
    private Boolean isPublic;

    @JsonProperty("link")
    private String link;

    @JsonProperty("description")
    private String description;

    @JsonProperty("dialog_with_user")
    private UserWithPhoto dialogWithUser;

    @JsonProperty("messages_count")
    private Integer messagesCount;

    @JsonProperty("chat_message_id")
    private String chatMessageId;
}
