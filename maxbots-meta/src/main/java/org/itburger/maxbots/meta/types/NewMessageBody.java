package org.itburger.maxbots.meta.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.itburger.maxbots.meta.types.attachment.AttachmentRequest;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewMessageBody {

    @JsonProperty("text")
    private String text;

    @JsonProperty("attachments")
    private List<AttachmentRequest> attachments;

    @JsonProperty("link")
    private NewMessageLink link;

    @JsonProperty("notify")
    @Builder.Default
    private Boolean notify = true;

    @JsonProperty("format")
    private TextFormat format;
}
