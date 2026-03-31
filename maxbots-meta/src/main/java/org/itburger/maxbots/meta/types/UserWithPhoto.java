package org.itburger.maxbots.meta.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserWithPhoto extends User {

    @JsonProperty("description")
    private String description;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    @JsonProperty("full_avatar_url")
    private String fullAvatarUrl;
}
