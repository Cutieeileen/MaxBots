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
public class FileAttachment extends Attachment {

    @JsonProperty("payload")
    private FilePayload payload;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FilePayload {
        @JsonProperty("id")
        private Long id;
        @JsonProperty("token")
        private String token;
        @JsonProperty("url")
        private String url;
        @JsonProperty("name")
        private String name;
        @JsonProperty("size")
        private Long size;
        @JsonProperty("mime_type")
        private String mimeType;
    }
}
