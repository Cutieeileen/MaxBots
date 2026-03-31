package org.itburger.maxbots.meta.api.methods.requests.messages;

import lombok.Builder;
import lombok.Getter;
import org.itburger.maxbots.meta.api.generics.BotApiMethod;
import org.itburger.maxbots.meta.api.methods.responses.SimpleResponse;
import org.itburger.maxbots.meta.types.NewMessageBody;
import org.itburger.maxbots.meta.types.attachment.AttachmentRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Builder
public class EditMessage extends BotApiMethod<SimpleResponse> {

    private String messageId;
    private String text;
    private List<AttachmentRequest> attachments;
    private Boolean notify;

    @Override
    public String getHttpMethod() {
        return "PUT";
    }

    @Override
    public String getEndpoint() {
        return "/messages";
    }

    @Override
    public Class<SimpleResponse> getResponseClass() {
        return SimpleResponse.class;
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> params = new HashMap<>();
        if (messageId != null) params.put("message_id", messageId);
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
}
