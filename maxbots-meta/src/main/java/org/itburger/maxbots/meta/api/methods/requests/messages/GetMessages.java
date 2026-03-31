package org.itburger.maxbots.meta.api.methods.requests.messages;

import lombok.Builder;
import lombok.Getter;
import org.itburger.maxbots.meta.api.generics.BotApiMethod;
import org.itburger.maxbots.meta.api.methods.responses.GetMessagesResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Builder
public class GetMessages extends BotApiMethod<GetMessagesResponse> {

    private Long chatId;
    private List<String> messageIds;
    private Long from;
    private Long to;
    private Integer count;

    @Override
    public String getHttpMethod() {
        return "GET";
    }

    @Override
    public String getEndpoint() {
        return "/messages";
    }

    @Override
    public Class<GetMessagesResponse> getResponseClass() {
        return GetMessagesResponse.class;
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> params = new HashMap<>();
        if (chatId != null) params.put("chat_id", chatId.toString());
        if (messageIds != null && !messageIds.isEmpty()) params.put("message_ids", String.join(",", messageIds));
        if (from != null) params.put("from", from.toString());
        if (to != null) params.put("to", to.toString());
        if (count != null) params.put("count", count.toString());
        return params;
    }
}
