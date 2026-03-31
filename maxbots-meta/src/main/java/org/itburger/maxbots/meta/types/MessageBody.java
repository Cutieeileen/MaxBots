package org.itburger.maxbots.meta.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.itburger.maxbots.meta.types.attachment.Attachment;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageBody {

    @JsonProperty("mid")
    private String mid;

    @JsonProperty("seq")
    private Long seq;

    @JsonProperty("text")
    private String text;

    @JsonProperty("attachments")
    private List<Attachment> attachments;

    @JsonProperty("reply_to")
    private String replyTo;
}
