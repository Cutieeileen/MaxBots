package org.itburger.maxbots.meta.api.methods.requests.chats;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.itburger.maxbots.meta.api.generics.BotApiMethod;
import org.itburger.maxbots.meta.api.methods.responses.GetPinResponse;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetChatPin extends BotApiMethod<GetPinResponse> {

    private Long chatId;

    @Override
    public String getHttpMethod() {
        return "GET";
    }

    @Override
    public String getEndpoint() {
        return "/chats/" + chatId + "/pin";
    }

    @Override
    public Class<GetPinResponse> getResponseClass() {
        return GetPinResponse.class;
    }
}
