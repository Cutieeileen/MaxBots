package org.itburger.maxbots.meta.api.methods.requests.chats;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.itburger.maxbots.meta.api.generics.BotApiMethod;
import org.itburger.maxbots.meta.api.methods.responses.SimpleResponse;

import java.util.HashMap;
import java.util.Map;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KickChatMember extends BotApiMethod<SimpleResponse> {

    private Long chatId;
    private Long userId;
    private Boolean block;

    @Override
    public String getHttpMethod() {
        return "DELETE";
    }

    @Override
    public String getEndpoint() {
        return "/chats/" + chatId + "/members";
    }

    @Override
    public Class<SimpleResponse> getResponseClass() {
        return SimpleResponse.class;
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> params = new HashMap<>();
        if (userId != null) params.put("user_id", String.valueOf(userId));
        if (block != null) params.put("block", String.valueOf(block));
        return params;
    }
}
