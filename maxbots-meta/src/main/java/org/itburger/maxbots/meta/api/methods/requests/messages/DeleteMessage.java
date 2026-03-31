package org.itburger.maxbots.meta.api.methods.requests.messages;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.itburger.maxbots.meta.api.generics.BotApiMethod;
import org.itburger.maxbots.meta.api.methods.responses.SimpleResponse;

import java.util.Collections;
import java.util.Map;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteMessage extends BotApiMethod<SimpleResponse> {

    private String messageId;

    @Override
    public String getHttpMethod() {
        return "DELETE";
    }

    @Override
    public String getEndpoint() {
        return "/messages";
    }

    @Override
    public Class<SimpleResponse> getResponseClass() {
        return SimpleResponse.class;
    }

    @Override
    public Map<String, String> getQueryParams() {
        return Collections.singletonMap("message_id", messageId);
    }
}
