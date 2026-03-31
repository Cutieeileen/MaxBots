package org.itburger.maxbots.meta.api.generics;

import java.util.Collections;
import java.util.Map;

public abstract class BotApiMethod<T> {

    public abstract String getHttpMethod();

    public abstract String getEndpoint();

    public abstract Class<T> getResponseClass();

    public Object getBody() {
        return null;
    }

    public Map<String, String> getQueryParams() {
        return Collections.emptyMap();
    }

    public boolean isMultipart() {
        return false;
    }
}
