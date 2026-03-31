package org.itburger.maxbots.meta.api.methods.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.itburger.maxbots.meta.types.Message;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetMessagesResponse {

    @JsonProperty("messages")
    private List<Message> messages;

    @JsonProperty("marker")
    private Long marker;
}
