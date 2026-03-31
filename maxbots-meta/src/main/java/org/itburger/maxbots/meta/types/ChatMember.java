package org.itburger.maxbots.meta.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatMember extends UserWithPhoto {

    @JsonProperty("last_access_time")
    private Long lastAccessTime;

    @JsonProperty("is_owner")
    private Boolean isOwner;

    @JsonProperty("is_admin")
    private Boolean isAdmin;

    @JsonProperty("join_time")
    private Long joinTime;

    @JsonProperty("permissions")
    private List<String> permissions;
}
