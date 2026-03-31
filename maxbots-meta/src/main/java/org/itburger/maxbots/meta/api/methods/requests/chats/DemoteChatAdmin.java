package org.itburger.maxbots.meta.api.methods.requests.chats;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.itburger.maxbots.meta.api.generics.BotApiMethod;
import org.itburger.maxbots.meta.api.methods.responses.SimpleResponse;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DemoteChatAdmin extends BotApiMethod<SimpleResponse> {

    private Long chatId;
    private Long userId;

    @Override
    public String getHttpMethod() {
        return "DELETE";
    }

    @Override
    public String getEndpoint() {
        return "/chats/" + chatId + "/members/admins";
    }

    @Override
    public Class<SimpleResponse> getResponseClass() {
        return SimpleResponse.class;
    }

    @Override
    public java.util.Map<String, String> getQueryParams() {
        java.util.Map<String, String> params = new java.util.HashMap<>();
        if (userId != null) params.put("user_id", String.valueOf(userId));
        return params;
    }
}
