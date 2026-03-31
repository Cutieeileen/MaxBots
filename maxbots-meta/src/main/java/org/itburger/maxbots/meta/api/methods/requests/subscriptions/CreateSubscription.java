package org.itburger.maxbots.meta.api.methods.requests.subscriptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.itburger.maxbots.meta.api.generics.BotApiMethod;
import org.itburger.maxbots.meta.api.methods.responses.SimpleResponse;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateSubscription extends BotApiMethod<SimpleResponse> {

    private String url;
    private String secret;
    private List<String> updateTypes;

    @Override
    public String getHttpMethod() {
        return "POST";
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
    public Object getBody() {
        return new SubscriptionRequest(url, secret, updateTypes);
    }

    @Getter
    @AllArgsConstructor
    public static class SubscriptionRequest {
        private final String url;
        private final String secret;
        private final List<String> updateTypes;
    }
}
