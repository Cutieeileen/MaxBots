package org.itburger.maxbots.meta.types.update;

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
public class MessageRemovedUpdate extends Update {

    @JsonProperty("message_id")
    private String messageId;

    @JsonProperty("chat_id")
    private Long chatId;

    @JsonProperty("user_id")
    private Long userId;
}
