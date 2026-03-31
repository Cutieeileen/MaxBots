package org.itburger.maxbots.meta.api.methods.requests.chats;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.itburger.maxbots.meta.api.generics.BotApiMethod;
import org.itburger.maxbots.meta.api.methods.responses.SimpleResponse;
import org.itburger.maxbots.meta.types.ChatAdminPermission;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PromoteChatAdmin extends BotApiMethod<SimpleResponse> {

    private Long chatId;
    private Long userId;
    private List<ChatAdminPermission> permissions;

    @Override
    public String getHttpMethod() {
        return "POST";
    }

    @Override
    public String getEndpoint() {
        return "/chats/" + chatId + "/members/admins";
    }

    @Override
    public Class<SimpleResponse> getResponseClass() {
        return SimpleResponse.class;
    }

    @Override
    public Object getBody() {
        return new AdminRequest(userId, permissions);
    }

    @Getter
    @AllArgsConstructor
    public static class AdminRequest {
        private final Long userId;
        private final List<ChatAdminPermission> permissions;
    }
}
