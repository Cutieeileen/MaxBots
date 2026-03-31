package org.itburger.maxbots.meta.api.methods.requests.chats;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.itburger.maxbots.meta.api.generics.BotApiMethod;
import org.itburger.maxbots.meta.api.methods.responses.SimpleResponse;
import org.itburger.maxbots.meta.types.SenderAction;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SendChatAction extends BotApiMethod<SimpleResponse> {

    private Long chatId;
    private SenderAction action;

    @Override
    public String getHttpMethod() {
        return "POST";
    }

    @Override
    public String getEndpoint() {
        return "/chats/" + chatId + "/actions";
    }

    @Override
    public Class<SimpleResponse> getResponseClass() {
        return SimpleResponse.class;
    }

    @Override
    public Object getBody() {
        return new ActionBody(action);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ActionBody {
        @JsonProperty("action")
        private SenderAction action;
    }
}
