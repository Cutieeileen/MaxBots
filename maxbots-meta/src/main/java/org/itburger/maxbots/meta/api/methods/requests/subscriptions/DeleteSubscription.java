package org.itburger.maxbots.meta.api.methods.requests.subscriptions;

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
public class DeleteSubscription extends BotApiMethod<SimpleResponse> {

    private String url;

    @Override
    public String getHttpMethod() {
        return "DELETE";
    }

    @Override
    public String getEndpoint() {
        return "/subscriptions";
    }

    @Override
    public Class<SimpleResponse> getResponseClass() {
        return SimpleResponse.class;
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> params = new HashMap<>();
        if (url != null) params.put("url", url);
        return params;
    }
}
