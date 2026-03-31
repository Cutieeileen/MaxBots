package org.itburger.maxbots.meta.api.methods.requests;

import org.itburger.maxbots.meta.api.generics.BotApiMethod;
import org.itburger.maxbots.meta.types.BotInfo;

public class GetMe extends BotApiMethod<BotInfo> {

    @Override
    public String getHttpMethod() {
        return "GET";
    }

    @Override
    public String getEndpoint() {
        return "/me";
    }

    @Override
    public Class<BotInfo> getResponseClass() {
        return BotInfo.class;
    }
}
