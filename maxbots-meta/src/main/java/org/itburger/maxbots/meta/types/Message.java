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
public class Message {

    @JsonProperty("sender")
    private User sender;

    @JsonProperty("recipient")
    private Recipient recipient;

    @JsonProperty("timestamp")
    private Long timestamp;

    @JsonProperty("link")
    private LinkedMessage link;

    @JsonProperty("body")
    private MessageBody body;

    @JsonProperty("stat")
    private MessageStat stat;

    @JsonProperty("url")
    private String url;

    public String getText() {
        return body != null ? body.getText() : null;
    }

    public String getMessageId() {
        return body != null ? body.getMid() : null;
    }

    public Long getChatId() {
        return recipient != null ? recipient.getChatId() : null;
    }

    public Long getUserId() {
        if (sender != null) return sender.getUserId();
        return recipient != null ? recipient.getUserId() : null;
    }
}
