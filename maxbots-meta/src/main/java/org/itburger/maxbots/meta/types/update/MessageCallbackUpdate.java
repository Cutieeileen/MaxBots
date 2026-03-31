package org.itburger.maxbots.meta.types.update;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.itburger.maxbots.meta.types.Callback;
import org.itburger.maxbots.meta.types.Message;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageCallbackUpdate extends Update {

    @JsonProperty("callback")
    private Callback callback;

    @JsonProperty("message")
    private Message message;

    @JsonProperty("user_locale")
    private String userLocale;
}
