package org.itburger.maxbots.meta.api.methods.requests.chats;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.itburger.maxbots.meta.api.generics.BotApiMethod;
import org.itburger.maxbots.meta.api.methods.responses.SimpleResponse;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PinMessage extends BotApiMethod<SimpleResponse> {

    private Long chatId;
    private String messageId;
    private Boolean notify;

    @Override
    public String getHttpMethod() {
        return "PUT";
    }

    @Override
    public String getEndpoint() {
        return "/chats/" + chatId + "/pin";
    }

    @Override
    public Class<SimpleResponse> getResponseClass() {
        return SimpleResponse.class;
    }

    @Override
    public Object getBody() {
        return new PinBody(messageId, notify != null ? notify : true);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PinBody {
        @JsonProperty("message_id")
        private String messageId;
        @JsonProperty("notify")
        private Boolean notify;
    }
}
