package org.itburger.maxbots.meta.api.methods.requests.chats;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.itburger.maxbots.meta.api.generics.BotApiMethod;
import org.itburger.maxbots.meta.api.methods.responses.GetMembersResponse;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetChatAdmins extends BotApiMethod<GetMembersResponse> {

    private Long chatId;

    @Override
    public String getHttpMethod() {
        return "GET";
    }

    @Override
    public String getEndpoint() {
        return "/chats/" + chatId + "/members/admins";
    }

    @Override
    public Class<GetMembersResponse> getResponseClass() {
        return GetMembersResponse.class;
    }
}
