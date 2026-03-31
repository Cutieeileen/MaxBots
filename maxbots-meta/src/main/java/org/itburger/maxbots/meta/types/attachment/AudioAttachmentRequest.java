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
public class AudioAttachmentRequest extends AttachmentRequest {

    @JsonProperty("payload")
    private AudioPayload payload;

    public static AudioAttachmentRequest of(String token) {
        return AudioAttachmentRequest.builder()
            .type("audio")
            .payload(new AudioPayload(token))
            .build();
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AudioPayload {
        @JsonProperty("token")
        private String token;
    }
}
