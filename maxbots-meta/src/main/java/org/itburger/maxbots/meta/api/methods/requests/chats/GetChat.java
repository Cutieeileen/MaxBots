package org.itburger.maxbots.meta.api.methods.requests.chats;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.itburger.maxbots.meta.api.generics.BotApiMethod;
import org.itburger.maxbots.meta.types.Chat;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetChat extends BotApiMethod<Chat> {

    private Long chatId;

    @Override
    public String getHttpMethod() {
        return "GET";
    }

    @Override
    public String getEndpoint() {
        return "/chats/" + chatId;
    }

    @Override
    public Class<Chat> getResponseClass() {
        return Chat.class;
    }
}
