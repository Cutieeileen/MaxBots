package org.itburger.maxbots.meta.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Callback {

    @JsonProperty("timestamp")
    private Long timestamp;

    @JsonProperty("callback_id")
    private String callbackId;

    @JsonProperty("payload")
    private String payload;

    @JsonProperty("user")
    private User user;
}
