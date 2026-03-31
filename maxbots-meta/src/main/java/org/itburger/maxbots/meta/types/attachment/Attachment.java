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
    @JsonSubTypes.Type(value = InlineKeyboardAttachment.class, name = "inline_keyboard"),
    @JsonSubTypes.Type(value = PhotoAttachment.class, name = "image"),
    @JsonSubTypes.Type(value = VideoAttachment.class, name = "video"),
    @JsonSubTypes.Type(value = AudioAttachment.class, name = "audio"),
    @JsonSubTypes.Type(value = FileAttachment.class, name = "file"),
    @JsonSubTypes.Type(value = StickerAttachment.class, name = "sticker"),
    @JsonSubTypes.Type(value = LocationAttachment.class, name = "location"),
    @JsonSubTypes.Type(value = ContactAttachment.class, name = "contact"),
    @JsonSubTypes.Type(value = ShareAttachment.class, name = "share")
})
public abstract class Attachment {

    @JsonProperty("type")
    private String type;
}
