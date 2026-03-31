package org.itburger.maxbots.meta.api.methods.requests.messages;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.itburger.maxbots.meta.api.generics.BotApiMethod;
import org.itburger.maxbots.meta.types.Message;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetMessage extends BotApiMethod<Message> {

    private String messageId;

    @Override
    public String getHttpMethod() {
        return "GET";
    }

    @Override
    public String getEndpoint() {
        return "/messages/" + messageId;
    }

    @Override
    public Class<Message> getResponseClass() {
        return Message.class;
    }
}
