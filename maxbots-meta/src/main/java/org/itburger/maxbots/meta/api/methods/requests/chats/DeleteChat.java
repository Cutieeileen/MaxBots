package org.itburger.maxbots.meta.api.methods.requests.chats;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.itburger.maxbots.meta.api.generics.BotApiMethod;
import org.itburger.maxbots.meta.api.methods.responses.SimpleResponse;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteChat extends BotApiMethod<SimpleResponse> {

    private Long chatId;

    @Override
    public String getHttpMethod() {
        return "DELETE";
    }

    @Override
    public String getEndpoint() {
        return "/chats/" + chatId;
    }

    @Override
    public Class<SimpleResponse> getResponseClass() {
        return SimpleResponse.class;
    }
}
