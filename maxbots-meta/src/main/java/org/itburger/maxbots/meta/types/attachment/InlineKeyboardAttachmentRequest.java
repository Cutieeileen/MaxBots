package org.itburger.maxbots.meta.types.attachment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.itburger.maxbots.meta.types.keyboard.InlineKeyboard;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InlineKeyboardAttachmentRequest extends AttachmentRequest {

    @JsonProperty("payload")
    private InlineKeyboard payload;

    public static InlineKeyboardAttachmentRequest of(InlineKeyboard keyboard) {
        return InlineKeyboardAttachmentRequest.builder()
            .type("inline_keyboard")
            .payload(keyboard)
            .build();
    }
}
