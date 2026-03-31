package org.itburger.maxbots.meta.api.methods.requests.chats;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.itburger.maxbots.meta.api.generics.BotApiMethod;
import org.itburger.maxbots.meta.api.methods.responses.GetMembersResponse;

import java.util.HashMap;
import java.util.Map;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetChatMembers extends BotApiMethod<GetMembersResponse> {

    private Long chatId;
    private Long marker;
    private Integer count;

    @Override
    public String getHttpMethod() {
        return "GET";
    }

    @Override
    public String getEndpoint() {
        return "/chats/" + chatId + "/members";
    }

    @Override
    public Class<GetMembersResponse> getResponseClass() {
        return GetMembersResponse.class;
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> params = new HashMap<>();
        if (marker != null) params.put("marker", String.valueOf(marker));
        if (count != null) params.put("count", String.valueOf(count));
        return params;
    }
}
