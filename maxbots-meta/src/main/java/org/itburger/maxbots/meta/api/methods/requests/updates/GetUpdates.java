package org.itburger.maxbots.meta.api.methods.requests.updates;

import lombok.Builder;
import lombok.Getter;
import org.itburger.maxbots.meta.api.generics.BotApiMethod;
import org.itburger.maxbots.meta.api.methods.responses.GetUpdatesResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Builder
public class GetUpdates extends BotApiMethod<GetUpdatesResponse> {

    private Integer limit;
    private Long marker;
    private Integer timeout;
    private List<String> types;

    @Override
    public String getHttpMethod() {
        return "GET";
    }

    @Override
    public String getEndpoint() {
        return "/updates";
    }

    @Override
    public Class<GetUpdatesResponse> getResponseClass() {
        return GetUpdatesResponse.class;
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> params = new HashMap<>();
        if (limit != null) params.put("limit", limit.toString());
        if (marker != null) params.put("marker", marker.toString());
        if (timeout != null) params.put("timeout", timeout.toString());
        if (types != null && !types.isEmpty()) params.put("types", String.join(",", types));
        return params;
    }
}
