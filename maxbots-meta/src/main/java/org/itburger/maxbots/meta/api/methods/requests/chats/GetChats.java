package org.itburger.maxbots.meta.api.methods.requests.chats;

import lombok.Builder;
import lombok.Getter;
import org.itburger.maxbots.meta.api.generics.BotApiMethod;
import org.itburger.maxbots.meta.api.methods.responses.GetChatsResponse;

import java.util.HashMap;
import java.util.Map;

@Getter
@Builder
public class GetChats extends BotApiMethod<GetChatsResponse> {

    private Integer count;
    private Long marker;

    @Override
    public String getHttpMethod() {
        return "GET";
    }

    @Override
    public String getEndpoint() {
        return "/chats";
    }

    @Override
    public Class<GetChatsResponse> getResponseClass() {
        return GetChatsResponse.class;
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> params = new HashMap<>();
        if (count != null) params.put("count", count.toString());
        if (marker != null) params.put("marker", marker.toString());
        return params;
    }
}
