package org.itburger.maxbots.meta.api.methods.requests.chats;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.itburger.maxbots.meta.api.generics.BotApiMethod;
import org.itburger.maxbots.meta.types.ChatMember;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetChatMemberMe extends BotApiMethod<ChatMember> {

    private Long chatId;

    @Override
    public String getHttpMethod() {
        return "GET";
    }

    @Override
    public String getEndpoint() {
        return "/chats/" + chatId + "/members/me";
    }

    @Override
    public Class<ChatMember> getResponseClass() {
        return ChatMember.class;
    }
}
