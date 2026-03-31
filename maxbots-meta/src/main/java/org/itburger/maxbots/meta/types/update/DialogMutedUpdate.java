package org.itburger.maxbots.meta.types.update;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.itburger.maxbots.meta.types.User;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DialogMutedUpdate extends Update {

    @JsonProperty("chat_id")
    private Long chatId;

    @JsonProperty("user")
    private User user;

    @JsonProperty("muted_until")
    private Long mutedUntil;

    @JsonProperty("user_locale")
    private String userLocale;
}
