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
public class VideoAttachment extends Attachment {

    @JsonProperty("payload")
    private VideoPayload payload;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class VideoPayload {
        @JsonProperty("id")
        private Long id;
        @JsonProperty("token")
        private String token;
        @JsonProperty("url")
        private String url;
        @JsonProperty("thumbnail")
        private String thumbnail;
        @JsonProperty("duration")
        private Integer duration;
        @JsonProperty("width")
        private Integer width;
        @JsonProperty("height")
        private Integer height;
    }
}
