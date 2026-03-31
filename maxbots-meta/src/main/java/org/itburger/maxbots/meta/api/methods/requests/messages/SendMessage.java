package org.itburger.maxbots.meta.api.methods.requests.messages;

import lombok.Builder;
import lombok.Getter;
import org.itburger.maxbots.meta.api.generics.BotApiMethod;
import org.itburger.maxbots.meta.api.methods.responses.SendMessageResponse;
import org.itburger.maxbots.meta.types.NewMessageBody;
import org.itburger.maxbots.meta.types.attachment.AttachmentRequest;
import org.itburger.maxbots.meta.types.attachment.InlineKeyboardAttachmentRequest;
import org.itburger.maxbots.meta.types.keyboard.InlineKeyboard;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Builder
public class SendMessage extends BotApiMethod<SendMessageResponse> {

    private Long userId;
    private Long chatId;
    private String text;
    private List<AttachmentRequest> attachments;
    private Boolean notify;
    private Object format;

    @Override
    public String getHttpMethod() {
        return "POST";
    }

    @Override
    public String getEndpoint() {
        return "/messages";
    }

    @Override
    public Class<SendMessageResponse> getResponseClass() {
        return SendMessageResponse.class;
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> params = new HashMap<>();
        if (userId != null) params.put("user_id", userId.toString());
        else if (chatId != null) params.put("chat_id", chatId.toString());
        return params;
    }

    @Override
    public Object getBody() {
        return NewMessageBody.builder()
            .text(text)
            .attachments(attachments)
            .notify(notify != null ? notify : true)
            .build();
    }

    public static SendMessage toUser(Long userId, String text) {
        return SendMessage.builder().userId(userId).text(text).build();
    }

    public static SendMessage toChat(Long chatId, String text) {
        return SendMessage.builder().chatId(chatId).text(text).build();
    }

    public SendMessage withKeyboard(InlineKeyboard keyboard) {
        return SendMessage.builder()
            .userId(userId)
            .chatId(chatId)
            .text(text)
            .attachments(Collections.singletonList(InlineKeyboardAttachmentRequest.of(keyboard)))
            .notify(notify)
            .build();
    }
}
