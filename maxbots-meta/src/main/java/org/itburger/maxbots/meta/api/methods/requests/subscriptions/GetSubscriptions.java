package org.itburger.maxbots.meta.api.methods.requests.subscriptions;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.itburger.maxbots.meta.api.generics.BotApiMethod;
import org.itburger.maxbots.meta.api.methods.responses.GetSubscriptionsResponse;

@Getter
@Builder
@NoArgsConstructor
public class GetSubscriptions extends BotApiMethod<GetSubscriptionsResponse> {

    @Override
    public String getHttpMethod() {
        return "GET";
    }

    @Override
    public String getEndpoint() {
        return "/subscriptions";
    }

    @Override
    public Class<GetSubscriptionsResponse> getResponseClass() {
        return GetSubscriptionsResponse.class;
    }
}
