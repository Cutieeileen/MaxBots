package org.itburger.maxbots.meta.api.methods.requests.chats;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.itburger.maxbots.meta.api.generics.BotApiMethod;
import org.itburger.maxbots.meta.api.methods.responses.SimpleResponse;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddChatMembers extends BotApiMethod<SimpleResponse> {

    private Long chatId;
    private List<Long> userIds;

    @Override
    public String getHttpMethod() {
        return "POST";
    }

    @Override
    public String getEndpoint() {
        return "/chats/" + chatId + "/members";
    }

    @Override
    public Class<SimpleResponse> getResponseClass() {
        return SimpleResponse.class;
    }

    @Override
    public Object getBody() {
        return new MembersRequest(userIds);
    }

    @Getter
    @AllArgsConstructor
    public static class MembersRequest {
        private final List<Long> userIds;
    }
}
