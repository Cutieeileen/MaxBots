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
public class VideoAttachmentRequest extends AttachmentRequest {

    @JsonProperty("payload")
    private VideoPayload payload;

    public static VideoAttachmentRequest of(String token) {
        return VideoAttachmentRequest.builder()
            .type("video")
            .payload(new VideoPayload(token))
            .build();
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class VideoPayload {
        @JsonProperty("token")
        private String token;
    }
}
