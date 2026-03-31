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
public class PhotoAttachment extends Attachment {

    @JsonProperty("payload")
    private PhotoPayload payload;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PhotoPayload {
        @JsonProperty("photo_id")
        private Long photoId;
        @JsonProperty("token")
        private String token;
        @JsonProperty("url")
        private String url;
    }
}
