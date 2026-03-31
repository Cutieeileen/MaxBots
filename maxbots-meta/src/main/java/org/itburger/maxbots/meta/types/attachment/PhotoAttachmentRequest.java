package org.itburger.maxbots.meta.types.attachment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PhotoAttachmentRequest extends AttachmentRequest {

    @JsonProperty("payload")
    private PhotoPayload payload;

    public static PhotoAttachmentRequest of(String token) {
        return PhotoAttachmentRequest.builder()
            .type("image")
            .payload(new PhotoPayload(token))
            .build();
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PhotoPayload {
        @JsonProperty("token")
        private String token;
    }
}
