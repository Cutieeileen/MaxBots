package org.itburger.maxbots.meta.api.methods.requests.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.itburger.maxbots.meta.api.generics.BotApiMethod;
import org.itburger.maxbots.meta.api.methods.responses.SimpleResponse;
import org.itburger.maxbots.meta.types.NewMessageBody;

import java.util.Collections;
import java.util.Map;

@Getter
@Builder
public class AnswerCallback extends BotApiMethod<SimpleResponse> {

    private String callbackId;
    private NewMessageBody message;
    private String notification;

    @Override
    public String getHttpMethod() {
        return "POST";
    }

    @Override
    public String getEndpoint() {
        return "/answers";
    }

    @Override
    public Class<SimpleResponse> getResponseClass() {
        return SimpleResponse.class;
    }

    @Override
    public Map<String, String> getQueryParams() {
        return Collections.singletonMap("callback_id", callbackId);
    }

    @Override
    public Object getBody() {
        return new AnswerCallbackBody(message, notification);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AnswerCallbackBody {
        @JsonProperty("message")
        private NewMessageBody message;
        @JsonProperty("notification")
        private String notification;
    }
}
