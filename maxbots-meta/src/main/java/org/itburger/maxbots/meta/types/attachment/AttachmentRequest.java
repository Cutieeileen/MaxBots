package org.itburger.maxbots.meta.types.attachment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = InlineKeyboardAttachmentRequest.class, name = "inline_keyboard"),
    @JsonSubTypes.Type(value = PhotoAttachmentRequest.class, name = "image"),
    @JsonSubTypes.Type(value = VideoAttachmentRequest.class, name = "video"),
    @JsonSubTypes.Type(value = AudioAttachmentRequest.class, name = "audio"),
    @JsonSubTypes.Type(value = FileAttachmentRequest.class, name = "file"),
    @JsonSubTypes.Type(value = ContactAttachmentRequest.class, name = "contact")
})
public abstract class AttachmentRequest {

    @JsonProperty("type")
    private String type;
}
