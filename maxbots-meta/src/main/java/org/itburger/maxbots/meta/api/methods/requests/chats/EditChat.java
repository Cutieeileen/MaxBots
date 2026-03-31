package org.itburger.maxbots.meta.api.methods.requests.chats;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.itburger.maxbots.meta.api.generics.BotApiMethod;
import org.itburger.maxbots.meta.types.Chat;
import org.itburger.maxbots.meta.types.Image;

@Getter
@Builder
public class EditChat extends BotApiMethod<Chat> {

    private Long chatId;
    private String title;
    private Image icon;
    private Boolean notify;

    @Override
    public String getHttpMethod() {
        return "PATCH";
    }

    @Override
    public String getEndpoint() {
        return "/chats/" + chatId;
    }

    @Override
    public Class<Chat> getResponseClass() {
        return Chat.class;
    }

    @Override
    public Object getBody() {
        return new EditChatBody(icon, title, notify);
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class EditChatBody {
        @JsonProperty("icon")
        private Image icon;
        @JsonProperty("title")
        private String title;
        @JsonProperty("notify")
        private Boolean notify;
    }
}
