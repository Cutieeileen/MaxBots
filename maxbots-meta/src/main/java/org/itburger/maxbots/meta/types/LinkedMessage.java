package org.itburger.maxbots.meta.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LinkedMessage {

    @JsonProperty("type")
    private LinkType type;

    @JsonProperty("sender")
    private User sender;

    @JsonProperty("chat_id")
    private Long chatId;

    @JsonProperty("message")
    private MessageBody message;
}
